package io.github.ehsankolivand.kmpbase.platform

import io.github.ehsankolivand.kmpbase.core.platform.Experiment
import io.github.ehsankolivand.kmpbase.core.platform.FeatureFlags
import io.github.ehsankolivand.kmpbase.core.platform.Flag
import io.github.ehsankolivand.kmpbase.core.platform.RefreshResult
import io.github.ehsankolivand.kmpbase.core.platform.Variant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class NoOpFeatureFlags : FeatureFlags {
    override suspend fun refresh(): RefreshResult = RefreshResult.NoChange
    override fun bool(flag: Flag.Bool): Boolean = flag.default
    override fun string(flag: Flag.Str): String = flag.default
    override fun int(flag: Flag.Int): Int = flag.default
    override fun double(flag: Flag.Dbl): Double = flag.default
    override fun <T : Any> json(flag: Flag.Json<T>): T = flag.default
    override fun <T : Any> experiment(experiment: Experiment<T>): Variant<T> =
        Variant.Default(key = experiment.key, value = experiment.default)
    override fun observe(flag: Flag.Bool): Flow<Boolean> = flowOf(flag.default)
}