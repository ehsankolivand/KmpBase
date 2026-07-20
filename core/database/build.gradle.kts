
    plugins {
        id("blueprint.kmp.library")
        alias(libs.plugins.sqldelight)
    }


kotlin {
    android {
        namespace = "io.github.ehsankolivand.kmpbase.core.database"
        compileSdk = libs.versions.compileSdk.get().toInt() // revisit at AGP 9.3+/10
        minSdk = libs.versions.minSdk.get().toInt()          // revisit at AGP 9.3+/10
    }
    sourceSets {
        commonMain.dependencies {
            api(projects.core.platform)
            api(libs.sqldelight.runtime)
            api(libs.sqldelight.coroutines.extensions)
        }
        androidMain.dependencies {
            implementation(libs.sqldelight.android.driver)
        }
        iosMain.dependencies {
            implementation(libs.sqldelight.native.driver)
        }
    }
}


    sqldelight {
        databases {
            create("AppDatabase") {
                packageName.set("io.github.ehsankolivand.kmpbase.core.database")
                schemaOutputDirectory.set(file("src/commonMain/sqldelight/io/github/ehsankolivand/kmpbase/core/database/db"))
                verifyMigrations.set(true)
            }
        }
    }