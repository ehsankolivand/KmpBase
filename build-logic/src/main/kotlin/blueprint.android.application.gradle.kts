import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    id("com.android.application")
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

extensions.configure<ApplicationExtension> {
    namespace = "io.github.ehsankolivand.kmpbase.android"
    compileSdk = libs.findVersion("compileSdk").get().requiredVersion.toInt()

    defaultConfig {
        applicationId = "io.github.ehsankolivand.kmpbase"
        minSdk = libs.findVersion("minSdk").get().requiredVersion.toInt()
        targetSdk = libs.findVersion("targetSdk").get().requiredVersion.toInt()
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

tasks.withType<KotlinJvmCompile>().configureEach {
    compilerOptions.jvmTarget.set(JvmTarget.JVM_11)
}
