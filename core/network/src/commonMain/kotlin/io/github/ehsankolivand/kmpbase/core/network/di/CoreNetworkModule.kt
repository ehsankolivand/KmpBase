package io.github.ehsankolivand.kmpbase.core.network.di

import io.github.ehsankolivand.kmpbase.core.network.AppJson
import io.github.ehsankolivand.kmpbase.core.network.HttpClientFactory
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.dsl.onClose

val coreNetworkModule: Module = module {
    single<Json> { AppJson }
    single { HttpClientFactory(get()) }
    single<HttpClient> { get<HttpClientFactory>().create() } onClose { it?.close() }
}