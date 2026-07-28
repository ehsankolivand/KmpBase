package io.github.ehsankolivand.kmpbase.core.database.di

import io.github.ehsankolivand.kmpbase.core.database.AppDatabase
import io.github.ehsankolivand.kmpbase.core.database.DriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

val coreDatabaseModule: Module = module {
    single { AppDatabase(get<DriverFactory>().createDriver()) }
}