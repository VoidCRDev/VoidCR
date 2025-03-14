package sh.miles.voidcr.apigen.impl;

import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.MethodSpec;
import com.palantir.javapoet.TypeSpec;
import sh.miles.crdatalib.CRDataLibUtils;
import sh.miles.crdatalib.data.CRData;
import sh.miles.voidcr.apigen.APIGenerator;
import sh.miles.voidcr.server.registry.Registries;
import sh.miles.voidcr.world.inventory.item.ItemKey;
import sh.miles.voidcr.world.inventory.item.ItemType;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class InterfaceFieldGen<T> implements APIGenerator {

    private final Class<T> fieldType;

    private String packagePath = null;
    private String registryName = null;
    private Class<?> keyType = null;
    private Function<CRData, List<String>> listCreator = null;

    public InterfaceFieldGen(final Class<T> fieldType) {
        this.fieldType = fieldType;
    }

    public InterfaceFieldGen<T> packagePath(String packagePath) {
        this.packagePath = packagePath;
        return this;
    }

    public InterfaceFieldGen<T> registryName(String registryName) {
        this.registryName = registryName;
        return this;
    }

    public InterfaceFieldGen<T> keyType(Class<?> keyType) {
        this.keyType = keyType;
        return this;
    }

    public InterfaceFieldGen<T> listCreator(Function<CRData, List<String>> listCreator) {
        this.listCreator = listCreator;
        return this;
    }

    @Override
    public void generate(final CRData data, final Path to) throws IOException {
        if (Files.notExists(to)) {
            Files.createDirectories(to);
        }

        List<FieldSpec> specs = new ArrayList<>();
        final var elements = listCreator.apply(data);
        for (final String id : elements) {
            final String keyPart = CRDataLibUtils.captureKeyPart(id, false);
            specs.add(FieldSpec
                    .builder(fieldType, keyPart.toUpperCase(), Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                    .addJavadoc("Generated {@link $T} with the id $S", fieldType, id)
                    .initializer("get($S)", keyPart)
                    .build()
            );
        }

        MethodSpec get = MethodSpec.methodBuilder("get")
                .addModifiers(Modifier.PRIVATE, Modifier.STATIC)
                .returns(fieldType)
                .addParameter(String.class, "key")
                .addStatement("return $T.%s.get($T.cosmicReach(key))" .formatted(registryName), Registries.class, keyType)
                .build();

        final TypeSpec generated = TypeSpec.interfaceBuilder(fieldType.getSimpleName() + "s")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(get)
                .addFields(specs)
                .addJavadoc("Generated class containing all default {@link $T}", fieldType)
                .build();

        final JavaFile javaFile = JavaFile.builder(packagePath, generated)
                .indent("    ")
                .build();

        javaFile.writeTo(to);
    }
}
