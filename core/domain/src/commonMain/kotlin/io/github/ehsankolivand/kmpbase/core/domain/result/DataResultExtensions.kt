package io.github.ehsankolivand.kmpbase.core.domain.result

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

inline fun <T, E, R> DataResult<T, E>.map(transform: (T) -> R): DataResult<R, E> = when (this) {
    is DataResult.Success -> DataResult.Success(transform(value))
    is DataResult.Failure -> this
    DataResult.Loading -> DataResult.Loading
}

inline fun <T, E, R> DataResult<T, E>.flatMap(transform: (T) -> DataResult<R, E>): DataResult<R, E> = when (this) {
    is DataResult.Success -> transform(value)
    is DataResult.Failure -> this
    DataResult.Loading -> DataResult.Loading
}

inline fun <T, E> DataResult<T, E>.onSuccess(action: (T) -> Unit): DataResult<T, E> {
    if (this is DataResult.Success) action(value)
    return this
}

inline fun <T, E> DataResult<T, E>.onFailure(action: (E) -> Unit): DataResult<T, E> {
    if (this is DataResult.Failure) action(error)
    return this
}

fun <T, E> DataResult<T, E>.getOrNull(): T? = when (this) {
    is DataResult.Success -> value
    else -> null
}

inline fun <T, E> DataResult<T, E>.getOrElse(fallback: (error: E?) -> T): T = when (this) {
    is DataResult.Success -> value
    is DataResult.Failure -> fallback(error)
    DataResult.Loading -> fallback(null)
}

fun <T, E, R> Flow<DataResult<T, E>>.mapSuccess(transform: (T) -> R): Flow<DataResult<R, E>> =
    map { result -> result.map(transform) }