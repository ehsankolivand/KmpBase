plugins {
    id("blueprint.kmp.library")
}

kotlin {
    android {
        namespace = "io.github.ehsankolivand.kmpbase.core.testing"
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