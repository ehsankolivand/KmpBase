package io.github.ehsankolivand.kmpbase.core.database

import app.cash.sqldelight.db.SqlDriver

interface DriverFactory {
    fun createDriver(): SqlDriver
}