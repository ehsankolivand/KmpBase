package io.github.ehsankolivand.kmpbase.core.data.error


import io.github.ehsankolivand.kmpbase.core.domain.result.DataResult
import io.github.ehsankolivand.kmpbase.core.domain.result.DomainError
import io.github.ehsankolivand.kmpbase.core.platform.CrashReporter
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import kotlin.coroutines.cancellation.CancellationException
import io.ktor.client.plugins.HttpRequestTimeoutException
import kotlinx.io.IOException


fun Throwable.toDomainError(): DomainError = when (this) {
    is ClientRequestException -> when (response.status.value) {
        401, 403 -> DomainError.Unauthorized
        404 -> DomainError.NotFound
        400, 422 -> DomainError.Validation(message = "Validation error")
        else -> DomainError.Network(cause = this)
    }
    is ServerResponseException -> DomainError.Network(cause = this)
    is HttpRequestTimeoutException -> DomainError.Network(cause = this)
    is IOException -> DomainError.Network(cause = this)
    else -> DomainError.Unknown(cause = this)
}


inline fun <T> runCatchingDomain(
    reporter: CrashReporter,
    block: () -> T,
): DataResult<T, DomainError> =
    try {
        DataResult.Success(block())
    } catch (c: CancellationException) {
        throw c
    } catch (t: Throwable) {
        val error = t.toDomainError()
        if (error is DomainError.Unknown) {
            reporter.recordException(t)
        }
        DataResult.Failure(error)
    }