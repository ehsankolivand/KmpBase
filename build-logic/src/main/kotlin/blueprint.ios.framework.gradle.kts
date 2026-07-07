import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

plugins {
    id("blueprint.kmp.library")
}

extensions.configure<KotlinMultiplatformExtension> {
    val xcfName = "Shared"

    iosArm64 { binaries.framework { baseName = xcfName; isStatic = true } }
    iosSimulatorArm64 { binaries.framework { baseName = xcfName; isStatic = true } }

    // TODO(S8): export Essenty for iOS state preservation once Decompose/Essenty are in the catalog:
    //   iosArm64 { binaries.framework { export(libs.essenty.stateKeeper) } }
    //   iosSimulatorArm64 { binaries.framework { export(libs.essenty.stateKeeper) } }
}
