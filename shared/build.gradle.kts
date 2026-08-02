plugins {
    id("blueprint.kmp.library")
    id("blueprint.compose")
    id("blueprint.ios.framework")
    alias(libs.plugins.kotlin.serialization)
}

kotlin {

    android {
        namespace = "io.github.ehsankolivand.kmpbase.shared"
        compileSdk = libs.versions.compileSdk.get().toInt()
        minSdk = libs.versions.minSdk.get().toInt()
    }

    sourceSets {
        jvmTest.dependencies {
            implementation(libs.koin.test)
        }
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