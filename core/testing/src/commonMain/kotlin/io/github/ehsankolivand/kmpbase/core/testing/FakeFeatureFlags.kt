package io.github.ehsankolivand.kmpbase.core.testing

import io.github.ehsankolivand.kmpbase.core.platform.Experiment
import io.github.ehsankolivand.kmpbase.core.platform.FeatureFlags
import io.github.ehsankolivand.kmpbase.core.platform.Flag
import io.github.ehsankolivand.kmpbase.core.platform.RefreshResult
import io.github.ehsankolivand.kmpbase.core.platform.Variant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FakeFeatureFlags(
    private val overrides: Map<String, Any> = emptyMap(),
) : FeatureFlags {

    private val observed = mutableMapOf<String, MutableStateFlow<Boolean>>()

    override suspend fun refresh(): RefreshResult = RefreshResult.NoChange

    override fun bool(flag: Flag.Bool): Boolean =
        overrides[flag.key] as? Boolean ?: flag.default

    override fun string(flag: Flag.Str): String =
        overrides[flag.key] as? String ?: flag.default

    override fun int(flag: Flag.Int): Int =
        overrides[flag.key] as? Int ?: flag.default

    override fun double(flag: Flag.Dbl): Double =
        overrides[flag.key] as? Double ?: flag.default

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> json(flag: Flag.Json<T>): T =
        overrides[flag.key] as? T ?: flag.default

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> experiment(experiment: Experiment<T>): Variant<T> =
        Variant.Default(experiment.key, overrides[experiment.key] as? T ?: experiment.default)

    override fun observe(flag: Flag.Bool): Flow<Boolean> =
        observed.getOrPut(flag.key) { MutableStateFlow(bool(flag)) }.asStateFlow()

    fun setFlag(flag: Flag.Bool, value: Boolean) {
        observed.getOrPut(flag.key) { MutableStateFlow(value) }.value = value
    }
}