pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "KmpBase"

// gen:begin GEN:INCLUDES
include(":core:domain")
include(":core:platform")
include(":core:testing")
include(":core:database")
include(":core:network")
include(":core:data")
include(":core:designsystem")
include(":shared")
include(":androidApp")
// gen:end GEN:INCLUDES
