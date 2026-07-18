package io.github.ehsankolivand.kmpbase.core.platform

expect abstract class PlatformContext

class BuildConfig(
    val isDebug: Boolean,
    val versionName: String,
    val versionCode: Long,
    val applicationId: String,
)

expect val APP_BUILD_CONFIG: BuildConfig