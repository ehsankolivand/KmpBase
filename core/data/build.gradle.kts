plugins {
    id("blueprint.kmp.library")
}

kotlin {
    android {
        namespace = "io.github.ehsankolivand.kmpbase.core.data"
 
    }
    sourceSets {
        commonMain.dependencies {
            api(projects.core.domain)
            api(projects.core.platform)
            implementation(projects.core.network)
        }
    }
}
