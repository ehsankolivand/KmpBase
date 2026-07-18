package io.github.ehsankolivand.kmpbase.core.platform

actual typealias PlatformContext = android.content.Context

actual val APP_BUILD_CONFIG: BuildConfig = BuildConfig(
    isDebug = true,
    versionName = "0.0.0",
    versionCode = 0L,
    applicationId = "io.github.ehsankolivand.kmpbase",
)