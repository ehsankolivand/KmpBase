plugins {
    id("blueprint.kmp.library")
}

kotlin {
    android {
        namespace = "io.github.ehsankolivand.kmpbase.core.platform"

    }
    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.coroutines.core)
            api(libs.kotlinx.datetime)
            implementation(libs.kermit)
        }
    }
}