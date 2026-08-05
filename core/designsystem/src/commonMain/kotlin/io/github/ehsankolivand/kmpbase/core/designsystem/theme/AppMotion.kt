package io.github.ehsankolivand.kmpbase.core.designsystem.theme

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

@Immutable
data class MotionDurations(
    val short2: Int = 100,
    val short3: Int = 150,
    val short4: Int = 200,
    val medium1: Int = 250,
    val medium2: Int = 300,
    val medium3: Int = 350,
    val medium4: Int = 400,
    val long2: Int = 500,
    val extraLong1: Int = 700,
)

@Immutable
data class MotionEasings(
    val emphasized: Easing = CubicBezierEasing(0.2f, 0f, 0f, 1f),
    val emphasizedDecelerate: Easing = CubicBezierEasing(0.05f, 0.7f, 0.1f, 1f),
    val emphasizedAccelerate: Easing = CubicBezierEasing(0.3f, 0f, 0.8f, 0.15f),
    val standard: Easing = CubicBezierEasing(0.2f, 0f, 0f, 1f),
    val standardDecelerate: Easing = CubicBezierEasing(0f, 0f, 0f, 1f),
    val standardAccelerate: Easing = CubicBezierEasing(0.3f, 0f, 1f, 1f),
)

@Immutable
class AppMotion(
    val duration: MotionDurations = MotionDurations(),
    val easing: MotionEasings = MotionEasings(),
) {
    fun <T> spatialFast(): SpringSpec<T> = spring(dampingRatio = 0.6f, stiffness = 800f)
    fun <T> spatialDefault(): SpringSpec<T> = spring(dampingRatio = 0.8f, stiffness = 380f)
    fun <T> spatialSlow(): SpringSpec<T> = spring(dampingRatio = 0.8f, stiffness = 200f)
    fun <T> effectsFast(): SpringSpec<T> = spring(dampingRatio = 1.0f, stiffness = 3800f)
    fun <T> effectsDefault(): SpringSpec<T> = spring(dampingRatio = 1.0f, stiffness = 1600f)

    fun <T> contentEnter(): TweenSpec<T> =
        tween(durationMillis = duration.medium3, easing = easing.emphasizedDecelerate)

    fun <T> refreshBarEnter(): TweenSpec<T> =
        tween(durationMillis = duration.short3, easing = easing.standard)

    fun <T> refreshBarExit(): TweenSpec<T> =
        tween(durationMillis = duration.short2, easing = easing.standard)

    fun <T> pressFeedback(): TweenSpec<T> =
        tween(durationMillis = duration.short2, easing = easing.standard)

    fun <T> thumbnailCrossfade(): TweenSpec<T> =
        tween(durationMillis = duration.medium1, easing = easing.emphasizedDecelerate)
}

val LocalAppMotion = staticCompositionLocalOf { AppMotion() }