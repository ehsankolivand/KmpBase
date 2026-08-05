package io.github.ehsankolivand.kmpbase.core.domain.usecase

fun interface UseCase<in P, out R> {
    suspend operator fun invoke(params: P): R
}