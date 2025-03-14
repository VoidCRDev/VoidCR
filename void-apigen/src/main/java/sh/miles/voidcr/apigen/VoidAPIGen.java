package sh.miles.voidcr.apigen;

import org.jspecify.annotations.NullMarked;
import sh.miles.crdatalib.CRDataLib;
import sh.miles.crdatalib.data.blocks.DataBlock;
import sh.miles.crdatalib.data.items.DataItem;
import sh.miles.crdatalib.parsing.schema.AssetType;
import sh.miles.voidcr.apigen.impl.InterfaceFieldGen;
import sh.miles.voidcr.util.NamedKey;
import sh.miles.voidcr.world.block.BlockType;
import sh.miles.voidcr.world.inventory.item.ItemKey;
import sh.miles.voidcr.world.inventory.item.ItemType;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@NullMarked
public final class VoidAPIGen {

    private static final Random RANDOM = new SecureRandom();
    private static final Set<APIGenerator> writers = new HashSet<>();

    static {
        writers.add(
                new InterfaceFieldGen<>(ItemType.class)
                        .packagePath("sh.miles.voidcr.types")
                        .registryName("ITEM")
                        .keyType(ItemKey.class)
                        .listCreator((d) -> d.items().stream().map(DataItem::id).sorted().toList())
        );
        writers.add(
                new InterfaceFieldGen<>(BlockType.class)
                        .packagePath("sh.miles.voidcr.types")
                        .registryName("BLOCK")
                        .keyType(NamedKey.class)
                        .listCreator((d) -> d.blocks().stream().map(DataBlock::id).sorted().toList())
        );
    }

    private VoidAPIGen() {
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Must provide path to read assets from");
            System.exit(1);
        }

        Path[] paths = parsePaths(args);
        if (paths.length != 2) {
            System.err.println("Must provide path to write output too");
            System.exit(1);
        }

        Path assets = paths[0];
        System.out.println("Acquired assets directory " + assets);
        Path output = paths[1];
        System.out.println("Acquired output director " + output);
        if (Files.notExists(assets)) {
            System.err.println("Must provide existing assets path");
            System.exit(1);
        }

        if (isZip(assets)) {
            System.out.println("Zip file detected unzipping assets");
            assets = unzipTemporarily(assets);
            System.out.println("Finished unzipping assets into " + assets);
        }

        final var data = CRDataLib.newParser()
                .assetRoot(assets.resolve("base"))
                .navigate(AssetType.BLOCK, "blocks")
                .navigate(AssetType.ITEM, "items").parseNow();
        try {
            for (final APIGenerator writer : VoidAPIGen.writers) {
                writer.generate(data, output);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Path unzipTemporarily(Path path) {
        try {
            final Path temp = Files.createTempDirectory(path.getParent(), "assets-");
            handleDiscord(temp);
            try (ZipFile file = new ZipFile(path.toFile())) {
                final Enumeration<? extends ZipEntry> contents = file.entries();
                ZipEntry entry;
                while (contents.hasMoreElements()) {
                    entry = contents.nextElement();
                    final Path location = temp.resolve(entry.getName());
                    if (!entry.getName().contains(".")) {
                        Files.createDirectories(location);
                    } else {
                        Files.createFile(location);
                        try (final OutputStream stream = Files.newOutputStream(location)) {
                            stream.write(file.getInputStream(entry).readAllBytes());
                        }
                    }
                }
            }

            return temp;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void handleDiscord(Path path) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                deleteFolderRecursively(path);
                System.out.println("Discarded Temporary Directory " + path);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }));
    }

    private static void deleteFolderRecursively(Path folder) throws IOException {
        Files.walkFileTree(folder, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static boolean isZip(final Path path) {
        final String fileName = path.getFileName().toString();
        return fileName.endsWith(".jar") || fileName.endsWith(".zip");
    }

    private static Path[] parsePaths(String[] args) {
        Path[] paths = new Path[2];
        int pathCount = 0;
        boolean quotes = false;
        final StringBuilder builder = new StringBuilder();
        for (final String next : args) {
            if (next.charAt(0) == '"') {
                quotes = true;
                builder.append(next.substring(1));
                continue;
            }

            if (quotes) {
                if (next.charAt(next.length() - 1) == '"') {
                    quotes = false;
                    builder.append(' ').append(next, 0, next.length() - 1);
                    paths[pathCount++] = Path.of(builder.toString());
                } else {
                    builder.append(' ').append(next);
                }
            } else {
                paths[pathCount++] = Path.of(next);
                builder.setLength(0);
            }
        }

        return paths;
    }
}
