package sh.miles.voidcr.dist;

import io.sigpipe.jbsdiff.InvalidHeaderException;
import io.sigpipe.jbsdiff.ui.FileUI;
import org.apache.commons.compress.compressors.CompressorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Launcher {

    public static final String PATCH_FILE = "crpatch.patch";
    public static final String BUILD_DATA = "build.txt";
    public static final String INPUT_JAR_NAME = "cr-input.jar";
    public static final String VOIDCR_JAR_NAME = "voidcr.jar";
    public static final String PATCH_NAME = "crpatch.patch";
    public static final Path CWD = Path.of(".");
    public static final Path LIBS = CWD.resolve("libs");

    public static void main(String[] args) {
        final Path inputJar = LIBS.resolve(INPUT_JAR_NAME);
        final BuildData buildData = BuildData.get();

        if (Files.notExists(inputJar)) {
            Scanner input = new Scanner(System.in);
            System.out.println("VoidCR version " + buildData.version() + " downloads from an unofficial Cosmic Reach archive at " + buildData.archiveUrl());
            System.out.println("If you want to continue downloading from the unofficial source type \"I agree\"");
            System.out.println("If you wish to manually download instead create a \"libs\" folder and put in the server jar as \"cr-input.jar\"");
            String nextLine = input.nextLine();

            if (!nextLine.equals("I agree")) {
                System.out.println("No libs/cr-input.jar found... exiting...");
                return;
            }

            downloadCosmicReachServer(buildData.archiveUrl);
            input = null;
        }

        if (Files.notExists(LIBS.resolve(VOIDCR_JAR_NAME))) {
            applyBinaryPatch();
        }

        System.out.println("Starting VoidCR...");
        start(buildData.mainClass(), args);
    }

    private static void start(final String mainClassName, final String[] args) {
        try {
            final URLClassLoader parent = new URLClassLoader(new URL[]{LIBS.resolve(VOIDCR_JAR_NAME).toUri().toURL()}, Launcher.class.getClassLoader().getParent());
            final Thread runner = new Thread(() -> {
                try {
                    final Class<?> mainClass = Class.forName(mainClassName, true, parent);
                    final MethodHandle handle = MethodHandles.lookup()
                            .findStatic(mainClass, "main", MethodType.methodType(void.class, String[].class))
                            .asFixedArity();
                    handle.invoke((Object) args);
                } catch (final Throwable t) {
                    throw new RuntimeException(t);
                }
            }, "VoidCR");
            runner.setContextClassLoader(parent);
            runner.start();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void applyBinaryPatch() {
        try {
            Files.copy(getResource("/" + PATCH_FILE), LIBS.resolve(PATCH_FILE), StandardCopyOption.REPLACE_EXISTING);
            FileUI.patch(LIBS.resolve(INPUT_JAR_NAME).toFile(), LIBS.resolve(VOIDCR_JAR_NAME).toFile(), LIBS.resolve(PATCH_NAME).toFile());
        } catch (IOException | CompressorException | InvalidHeaderException e) {
            throw new RuntimeException(e);
        }
    }

    private static void downloadCosmicReachServer(String url) {
        System.out.println("Beginning download of Cosmic Reach server from " + url);
        try {
            if (Files.notExists(LIBS)) {
                Files.createDirectories(LIBS);
            }
            final URL downloadURL = URI.create(url).toURL();
            Files.copy(downloadURL.openStream(), LIBS.resolve(INPUT_JAR_NAME), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished download of Cosmic Reach server continuing boot sequence");
    }

    private static InputStream getResource(String path) {
        return Launcher.class.getResourceAsStream(path);
    }

    private record BuildData(String archiveUrl, String version, String mainClass) {
        public static BuildData get() {
            try (final BufferedReader reader = new BufferedReader(new InputStreamReader(getResource("/" + BUILD_DATA)))) {
                return new BuildData(reader.readLine(), reader.readLine(), reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
