package io.github.ehsankolivand.kmpbase.core.platform

import kotlinx.coroutines.flow.Flow

sealed interface Flag<T : Any> {
    val key: String
    val default: T

    data class Bool(override val key: String, override val default: Boolean) : Flag<Boolean>
    data class Str(override val key: String, override val default: String) : Flag<String>
    data class Int(override val key: String, override val default: kotlin.Int) : Flag<kotlin.Int>
    data class Dbl(override val key: String, override val default: Double) : Flag<Double>
    data class Json<T : Any>(override val key: String, override val default: T) : Flag<T>
}

interface Experiment<T : Any> {
    val key: String
    val default: T
}

sealed interface Variant<T : Any> {
    val key: String
    val value: T

    data class Control<T : Any>(override val key: String, override val value: T) : Variant<T>
    data class Treatment<T : Any>(override val key: String, override val value: T) : Variant<T>
    data class Default<T : Any>(override val key: String, override val value: T) : Variant<T>
}

sealed interface RefreshResult {
    data object Success : RefreshResult
    data object NoChange : RefreshResult
    data class Failed(val cause: Throwable) : RefreshResult
}

interface FeatureFlags {
    suspend fun refresh(): RefreshResult
    fun bool(flag: Flag.Bool): Boolean
    fun string(flag: Flag.Str): String
    fun int(flag: Flag.Int): Int
    fun double(flag: Flag.Dbl): Double
    fun <T : Any> json(flag: Flag.Json<T>): T
    fun <T : Any> experiment(experiment: Experiment<T>): Variant<T>
    fun observe(flag: Flag.Bool): Flow<Boolean>
}