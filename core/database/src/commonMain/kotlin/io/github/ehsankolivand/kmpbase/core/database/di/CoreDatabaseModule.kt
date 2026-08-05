package io.github.ehsankolivand.kmpbase.core.database.di

import app.cash.sqldelight.db.SqlDriver
import io.github.ehsankolivand.kmpbase.core.database.AppDatabase
import io.github.ehsankolivand.kmpbase.core.database.DriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.dsl.onClose


val coreDatabaseModule: Module = module {
    single<SqlDriver> { get<DriverFactory>().createDriver() } onClose { it?.close() }
    single { AppDatabase(get()) }
}