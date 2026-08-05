package io.github.ehsankolivand.kmpbase.core.domain.mvi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MviState
interface MviIntent
interface MviEffect

interface Store<S : MviState, I : MviIntent, E : MviEffect> {
    val state: StateFlow<S>
    val effects: Flow<E>
    fun dispatch(intent: I)
}

fun interface Reducer<S : MviState, I : MviIntent> {
    fun reduce(state: S, intent: I): S
}