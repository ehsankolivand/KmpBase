package io.github.ehsankolivand.kmpbase.di

import io.github.ehsankolivand.kmpbase.core.network.di.coreNetworkModule
import io.github.ehsankolivand.kmpbase.core.platform.AnalyticsTracker
import io.github.ehsankolivand.kmpbase.core.platform.CrashReporter
import io.github.ehsankolivand.kmpbase.core.platform.FeatureFlags
import io.github.ehsankolivand.kmpbase.platform.NoOpAnalyticsTracker
import io.github.ehsankolivand.kmpbase.platform.NoOpCrashReporter
import io.github.ehsankolivand.kmpbase.platform.NoOpFeatureFlags
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes
import org.koin.dsl.module

expect fun platformFeatureModules(): List<Module>

val defaultsModule: Module = module {
    single<CrashReporter> { NoOpCrashReporter() }
    single<AnalyticsTracker> { NoOpAnalyticsTracker() }
    single<FeatureFlags> { NoOpFeatureFlags() }
}

val appModules: List<Module> = listOf(
    platformModule(),
    defaultsModule,
    coreNetworkModule,
    // gen:begin GEN:KOIN
    // gen:end GEN:KOIN
) + platformFeatureModules()

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        includes(config)
        modules(appModules)
    }
}