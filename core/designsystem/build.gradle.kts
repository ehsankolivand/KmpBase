plugins {
    id("blueprint.kmp.library")
    id("blueprint.compose")
}

kotlin {
    android {
        namespace = "io.github.ehsankolivand.kmpbase.core.designsystem"
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.jetbrains.lifecycle.runtime.compose)
            implementation(projects.core.platform)
            api(libs.compose.runtime)
            api(libs.compose.foundation)
            api(libs.compose.ui)
            api(libs.compose.material3)
            implementation(libs.compose.components.resources)
        }
    }
}
compose.resources {
    publicResClass = true
    packageOfResClass = "io.github.ehsankolivand.kmpbase.core.designsystem.resources"
    generateResClass = always
}