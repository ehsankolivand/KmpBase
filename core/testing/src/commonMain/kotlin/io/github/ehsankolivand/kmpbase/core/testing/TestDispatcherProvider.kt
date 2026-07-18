package io.github.ehsankolivand.kmpbase.core.testing

import io.github.ehsankolivand.kmpbase.core.platform.DispatcherProvider
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher

class TestDispatcherProvider(
    private val dispatcher: TestDispatcher = StandardTestDispatcher(),
) : DispatcherProvider {
    override val main: TestDispatcher get() = dispatcher
    override val mainImmediate: TestDispatcher get() = dispatcher
    override val default: TestDispatcher get() = dispatcher
    override val io: TestDispatcher get() = dispatcher
    override val unconfined: TestDispatcher get() = dispatcher
}