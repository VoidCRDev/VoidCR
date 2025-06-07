rootProject.name = "VoidCR"

gradle.rootProject {
    version = "1.0.0-SNAPSHOT"
    group = "sh.miles.voidcr"
}

include(
    "void-api",
    "void-apigen",
    "void-dist",
    "void-server",
    "void-test-plugin"
)
