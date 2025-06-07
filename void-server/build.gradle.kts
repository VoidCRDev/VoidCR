import sh.miles.voidcr.task.ApplyPatchesFuzzyTask
import sh.miles.voidcr.task.ApplyPatchesTask
import sh.miles.voidcr.task.BuildPatchesTask
import sh.miles.voidcr.task.DecompileTask
import sh.miles.voidcr.task.FilterAndTransformZipTask
import sh.miles.voidcr.task.SetupSourcesTask
import sh.miles.voidcr.task.DownloadCosmicReachServer
import sh.miles.voidcr.task.build.BinaryPatchTask
import sh.miles.voidcr.task.build.CreateBuildDataTask

plugins {
    java
    alias(libs.plugins.shadow)
}

val crVersion = properties["cr-version"] as String
val crPhase = "alpha"

group = rootProject.group
version = rootProject.name

repositories {
    mavenCentral()
    maven("https://jitpack.io") {
        content {
            includeGroup("com.github.Hangman")
        }
    }
}

sourceSets {
    main {
        java.srcDir(files("src/cosmic-reach/java"))
    }
}

dependencies {
    // Cosmic Reach
    implementation(libs.libgdx.api)
    implementation(libs.libgdx.headless)
    implementation(libs.tuningfork)
    implementation(libs.netty.all)
    implementation(libs.lz4)
    // Cosmic Reach

    implementation(libs.gson)
    implementation(libs.guava)
    implementation(platform(libs.log4j.bom))
    implementation(libs.log4j.api)
    runtimeOnly(libs.log4j.core)
    implementation(libs.jspecify)

    implementation(project(":void-api"))
}

tasks.jar {
    enabled = false
}

tasks.shadowJar {
    archiveFileName = "VoidCR-${crVersion}.jar"
    manifest {
        attributes(
            "Implementation-Title" to "VoidCR",
            "Implementation-Version" to rootProject.version,
            "Main-Class" to "sh.miles.voidcr.Main"
        )
    }

    from(project.layout.buildDirectory.file("generated/cosmic-reach-assets"))

    dependsOn(generateResources)
}

val assetsFolder = rootProject.file("assets")
val buildDataFolder = rootProject.file("build-data")

val filterJar by tasks.registering(FilterAndTransformZipTask::class) {
    group = "voidcr-setup"
    val exclusions = listOf(
        "de/",
        "com/",
        "io/",
        "net/jpountz/"
    )

    this.inputJar = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion.jar")
    this.outputJar = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion-filtered.jar")
    this.atFile = buildDataFolder.resolve("voidcr.ajex")
    this.filterFunction.set { entry ->
        for (exclusion in exclusions) {
            if (entry.startsWith(exclusion)) {
                return@set false
            }
        }

        return@set entry.endsWith(".class")
    }
}

val decompileJar by tasks.registering(DecompileTask::class) {
    group = "voidcr-setup"
    this.decompileTarget = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion-filtered.jar")
    this.decompilerOutput = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion-decompiled.jar")
    this.decompilerArguments = listOf(
        "-dcc=1",
        "-ega=1",
        "-log=WARN",
        "-pll=120",
        "--file",
    )

    dependsOn(filterJar)
}

val setupSources by tasks.registering(SetupSourcesTask::class) {
    group = "voidcr-setup"

    this.patchedJar = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion-patched.jar")
    this.sourceDir = file("src/cosmic-reach/java")
}

val applyPatches by tasks.registering(ApplyPatchesTask::class) {
    group = "voidcr-patching"
    this.patchDir = file("patches")
    this.inputFile = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion-decompiled.jar")
    this.outputJar = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion-patched.jar")
    this.failedPatchesJar = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion-failed-patched.jar")

    dependsOn(decompileJar)
}

val applyPatchesFuzzy by tasks.registering(ApplyPatchesFuzzyTask::class) {
    group = "voidcr-patching"
    this.patchDir = file("patches")
    this.inputFile = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion-decompiled.jar")
    this.outputJar = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion-patched.jar")
    this.failedPatchesJar = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion-failed-patched.jar")

    dependsOn(decompileJar)
}

val buildPatches by tasks.registering(BuildPatchesTask::class) {
    group = "voidcr-patching"
    this.patchDir = file("patches")
    this.sourceDir = file("src/cosmic-reach/java")
    this.decompiledJar = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion-decompiled.jar")
}

val generateResources by tasks.registering(Copy::class) {
    from(zipTree(assetsFolder.resolve("Cosmic-Reach-Server-$crVersion.jar")))
    include("base/**", "build_assets/**", "icons/**", "post_build/**", "assets.txt")
    into(project.layout.buildDirectory.file("generated/cosmic-reach-assets"))
}

val downloadCosmicReachServer by tasks.registering(DownloadCosmicReachServer::class) {
    group = "voidcr-setup"

    this.archiveRepoUrl = "https://raw.githubusercontent.com/CRModders/CosmicArchive/main/versions/"
    this.phase = crPhase
    this.version = crVersion
    this.outputJar = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion.jar")
}

val createBinaryPatch by tasks.registering(BinaryPatchTask::class) {
    group = "voidcr-build"

    cosmicReachJar = assetsFolder.resolve("Cosmic-Reach-Server-$crVersion.jar")
    patchFile = assetsFolder.resolve("build/crpatch.patch")
    voidCRJar = tasks.shadowJar.get().archiveFile

    dependsOn(tasks.shadowJar)
}

val createBuildData by tasks.registering(CreateBuildDataTask::class) {
    group = "voidcr-build"

    val dataSet = downloadCosmicReachServer.get();
    archiveRepoUrl = dataSet.archiveRepoUrl
    phase = dataSet.phase
    version = dataSet.version
    mainClass = "sh.miles.voidcr.Main"

    outputFile = assetsFolder.resolve("build/build.txt")
}

tasks.register("setup") {
    group = "voidcr-setup"

    filterJar.get().mustRunAfter(downloadCosmicReachServer)
    setupSources.get().mustRunAfter(applyPatches)
    dependsOn(downloadCosmicReachServer, filterJar, decompileJar, applyPatches, setupSources)
}

tasks.register("update") {
    group = "voidcr-setup"

    setupSources.get().mustRunAfter(applyPatchesFuzzy)
    dependsOn(filterJar, decompileJar, applyPatchesFuzzy, setupSources)
}

tasks.build {
    dependsOn(tasks.shadowJar)
    dependsOn(createBinaryPatch)
    dependsOn(createBuildData)
}
