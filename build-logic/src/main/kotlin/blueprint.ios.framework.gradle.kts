import org.gradle.api.artifacts.VersionCatalogsExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    id("blueprint.kmp.library")
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
val stateKeeper = libs.findLibrary("essenty-state-keeper").get()

extensions.configure<KotlinMultiplatformExtension> {
    val xcfName = "Shared"
    val xcf = XCFramework(xcfName)

    listOf(iosArm64(), iosSimulatorArm64()).forEach { target ->
        target.binaries.framework {
            baseName = xcfName
            isStatic = true
            export(stateKeeper)
            xcf.add(this)
        }
    }
}