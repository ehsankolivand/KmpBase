package io.github.ehsankolivand.kmpbase.core.domain.result

sealed interface DataResult<out T, out E> {
    data class Success<T>(val value: T) : DataResult<T, Nothing>
    data class Failure<E>(val error: E) : DataResult<Nothing, E>
    data object Loading : DataResult<Nothing, Nothing>
}

sealed interface DomainError {
    data class Network(val cause: Throwable?) : DomainError
    data object NotFound : DomainError
    data class Validation(val message: String?) : DomainError
    data object Unauthorized : DomainError
    data class Unknown(val cause: Throwable?) : DomainError
}