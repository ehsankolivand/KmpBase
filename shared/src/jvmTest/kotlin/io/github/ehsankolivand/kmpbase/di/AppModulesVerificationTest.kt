package io.github.ehsankolivand.kmpbase.di

import app.cash.sqldelight.db.SqlDriver
import io.github.ehsankolivand.kmpbase.core.database.DriverFactory
import io.ktor.client.engine.HttpClientEngine
import kotlin.test.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.verify.verify

@OptIn(KoinExperimentalAPI::class)
class AppModulesVerificationTest {

    private val externallyProvided = listOf(
        DriverFactory::class,
        HttpClientEngine::class,
        SqlDriver::class,
    )

    @Test
    fun appModulesAreFullyWired() {
        appModules.forEach { module ->
            module.verify(extraTypes = externallyProvided)
        }
    }
}