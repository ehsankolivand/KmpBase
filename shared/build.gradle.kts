plugins {
    id("blueprint.kmp.library")
    id("blueprint.compose")
    alias(libs.plugins.kotlin.serialization)
}

kotlin {

    android {
        namespace = "io.github.ehsankolivand.kmpbase.shared"
        compileSdk = libs.versions.compileSdk.get().toInt()
        minSdk = libs.versions.minSdk.get().toInt()
    }

    sourceSets {
        commonMain.dependencies {
            api(projects.core.domain)
            api(projects.core.platform)
            api(projects.core.designsystem)
            implementation(projects.core.data)
            implementation(projects.core.network)
            implementation(projects.core.database)
            api(libs.koin.core)
            api(libs.decompose)
            api(libs.decompose.extensions.compose)
            api(libs.essenty.state.keeper)
        }
    }
}