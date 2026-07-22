package io.github.ehsankolivand.kmpbase.core.network

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpClientFactory(
    private val json: Json = AppJson,
) {
    fun create(extraConfig: HttpClientConfig<*>.() -> Unit = {}): HttpClient =
        HttpClient {
            expectSuccess = true
            install(ContentNegotiation) {
                json(json)
            }
            extraConfig()
        }
}