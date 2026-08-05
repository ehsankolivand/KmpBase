import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile
import org.gradle.api.artifacts.VersionCatalogsExtension

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
}
val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
kotlin {
    jvm()
    iosArm64()
    iosSimulatorArm64()

    // Android target; namespace/compileSdk/minSdk are set per-module
    // (AGP 9.2.x doesn't reliably expose them from plugin code — revisit at AGP 9.3+/10).
    android {
        compileSdk = libs.findVersion("compileSdk").get().requiredVersion.toInt()
        minSdk = libs.findVersion("minSdk").get().requiredVersion.toInt()
        withHostTest {}
    }
    compilerOptions{
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
    applyDefaultHierarchyTemplate()
    sourceSets {
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}

tasks.withType<KotlinJvmCompile>().configureEach {
    compilerOptions.jvmTarget.set(JvmTarget.JVM_11)
}
