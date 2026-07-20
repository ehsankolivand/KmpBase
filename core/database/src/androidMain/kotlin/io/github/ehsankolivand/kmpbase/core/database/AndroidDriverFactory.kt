package io.github.ehsankolivand.kmpbase.core.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import io.github.ehsankolivand.kmpbase.core.platform.PlatformContext

class AndroidDriverFactory(
    private val context: PlatformContext,
) : DriverFactory {
    override fun createDriver(): SqlDriver =
        AndroidSqliteDriver(AppDatabase.Schema, context, "app.db")
}