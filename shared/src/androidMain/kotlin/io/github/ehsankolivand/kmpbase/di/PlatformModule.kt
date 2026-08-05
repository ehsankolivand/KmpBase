package io.github.ehsankolivand.kmpbase.di

import io.github.ehsankolivand.kmpbase.core.database.AndroidDriverFactory
import io.github.ehsankolivand.kmpbase.core.database.DriverFactory
import io.github.ehsankolivand.kmpbase.core.platform.ClockSeam
import io.github.ehsankolivand.kmpbase.core.platform.DefaultClockSeam
import io.github.ehsankolivand.kmpbase.core.platform.DefaultDispatcherProvider
import io.github.ehsankolivand.kmpbase.core.platform.DefaultLogger
import io.github.ehsankolivand.kmpbase.core.platform.DefaultUuidGenerator
import io.github.ehsankolivand.kmpbase.core.platform.DispatcherProvider
import io.github.ehsankolivand.kmpbase.core.platform.Logger
import io.github.ehsankolivand.kmpbase.core.platform.UuidGenerator
import org.koin.core.module.Module
import org.koin.dsl.module
import io.github.ehsankolivand.kmpbase.core.database.di.coreDatabaseModule

actual fun platformModule(): Module = module {
    single<DispatcherProvider> { DefaultDispatcherProvider() }
    single<ClockSeam> { DefaultClockSeam() }
    single<UuidGenerator> { DefaultUuidGenerator() }
    single<Logger> { DefaultLogger() }
    single<DriverFactory> { AndroidDriverFactory(get()) }
}
actual fun platformFeatureModules(): List<Module> = listOf(coreDatabaseModule)