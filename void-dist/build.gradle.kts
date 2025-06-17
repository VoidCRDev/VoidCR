plugins {
    java
    alias(libs.plugins.shadow)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.jbsdiff)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(properties["java-language"].toString())
    }
}

tasks.jar {
    enabled = false
}

tasks.shadowJar {
    archiveFileName = "VoidCR-Launcher.jar"

    manifest {
        attributes(
            "Main-Class" to "sh.miles.voidcr.dist.Launcher"
        )
    }

    from(rootProject.file("assets/build/crpatch.patch"), rootProject.file("assets/build/build.txt"))
}

tasks.build {
    dependsOn(tasks.shadowJar)
}
