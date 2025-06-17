import sh.miles.voidcr.task.FilterAndTransformZipTask

plugins {
    java
    alias(libs.plugins.shadow)
}

val crVersion = properties["cr-version"] as String
val assetsFolder = rootProject.file("assets")

repositories {
    mavenCentral()
    maven("https://maven.miles.sh/snapshots")
}

dependencies {
    implementation(libs.jspecify)
    implementation(libs.javapoet)
    implementation(libs.crdatalib) {
        isChanging = true
    }
    implementation(project(":void-api"))
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
    archiveVersion = ""
    archiveClassifier = ""

    manifest {
        attributes(
            "Implementation-Title" to "VoidCR-APIGen",
            "Implementation-Version" to rootProject.version,
            "Main-Class" to "sh.miles.voidcr.apigen.VoidAPIGen"
        )
    }
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

val unzipAssets by tasks.register<FilterAndTransformZipTask>("unzipAssets") {
    this.inputJar = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion.jar")
    this.outputJar = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion-assets.jar")
    this.atFile = rootProject.file("build-data/voidcr.ajex")
    this.filterFunction.set { entry ->
        return@set (entry.contains("base/") && !entry.contains(".class"))
    }
}

tasks.register<JavaExec>("generateSources") {
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass = "sh.miles.voidcr.apigen.VoidAPIGen"
    args = listOf("../assets/Cosmic-Reach-Server-$crVersion-assets.jar", "../void-api/src/generated/java")
    dependsOn(unzipAssets)
}
