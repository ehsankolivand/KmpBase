plugins {
    id("blueprint.kmp.library")
}

kotlin {
    android {
        namespace = "io.github.ehsankolivand.kmpbase.core.testing"
        compileSdk = libs.versions.compileSdk.get().toInt() // revisit at AGP 9.3+/10
        minSdk = libs.versions.minSdk.get().toInt()          // revisit at AGP 9.3+/10
    }
    sourceSets {
        commonMain.dependencies {
            api(projects.core.domain)
            api(projects.core.platform)
            api(libs.kotlinx.coroutines.test)
            api(libs.turbine)
        }
    }
}