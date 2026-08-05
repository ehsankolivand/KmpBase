plugins {
    id("blueprint.kmp.library")
}

kotlin {
    android {
        namespace = "io.github.ehsankolivand.kmpbase.core.domain"
    }
    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.coroutines.core)
        }
    }
}
