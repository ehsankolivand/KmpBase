plugins {
    id("blueprint.kmp.library")
}


kotlin {
    android {
        namespace = "io.github.ehsankolivand.kmpbase.core.network"

    }
    sourceSets {
        commonMain.dependencies {
            api(libs.koin.core)
            api(libs.ktor.client.core)
            api(libs.kotlinx.serialization.json)
            implementation(projects.core.platform)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
        jvmMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }
    }
}