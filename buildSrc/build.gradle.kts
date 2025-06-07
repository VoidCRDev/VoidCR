plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
    maven("https://maven.miles.sh/snapshots")
}

dependencies {
    implementation(libs.vineflower)
    implementation(libs.diffpath)
    implementation(libs.jbsdiff)
    implementation(libs.asm)
    implementation(libs.artistan) {
        isChanging = true
    }
}
