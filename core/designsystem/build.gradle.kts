plugins {
    id("blueprint.kmp.library")
    id("blueprint.compose")
}

kotlin {
    android {
        namespace = "io.github.ehsankolivand.kmpbase.core.designsystem"
        compileSdk = libs.versions.compileSdk.get().toInt() // revisit at AGP 9.3+/10
        minSdk = libs.versions.minSdk.get().toInt()          // revisit at AGP 9.3+/10
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.jetbrains.lifecycle.runtime.compose)
            implementation(projects.core.platform)
            api(libs.compose.runtime)
            api(libs.compose.foundation)
            api(libs.compose.ui)
            api(libs.compose.material3)
        }
    }
}