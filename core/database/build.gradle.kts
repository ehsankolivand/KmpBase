
    plugins {
        id("blueprint.kmp.library")
        alias(libs.plugins.sqldelight)
    }


kotlin {
    android {
        namespace = "io.github.ehsankolivand.kmpbase.core.database"
    }
    sourceSets {
        commonMain.dependencies {
            api(libs.koin.core)
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