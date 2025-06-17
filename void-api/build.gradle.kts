plugins {
    `java-library`
    idea
}

group = rootProject.group
version = rootProject.name

repositories {
    mavenCentral()
}

idea {
    module {
        generatedSourceDirs.add(file("src/generated/java"))
    }
}

sourceSets {
    main {
        java {
            srcDir("src/generated/java")
        }
    }
}

dependencies {
    api(libs.libgdx.api)
    api(libs.jspecify)
    api(libs.gson)
    api(libs.guava)
    api(platform(libs.log4j.bom))
    api(libs.log4j.api)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(properties["java-language"].toString())
    }
}
