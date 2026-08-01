package io.github.ehsankolivand.kmpbase.core.platform

import co.touchlab.kermit.Logger as Kermit

class DefaultLogger(
    private val kermit: Kermit = Kermit,
) : Logger {

    private fun at(tag: String?): Kermit = if (tag == null) kermit else kermit.withTag(tag)

    override fun v(tag: String?, throwable: Throwable?, message: () -> String) =
        at(tag).v(throwable = throwable, message = message)

    override fun d(tag: String?, throwable: Throwable?, message: () -> String) =
        at(tag).d(throwable = throwable, message = message)

    override fun i(tag: String?, throwable: Throwable?, message: () -> String) =
        at(tag).i(throwable = throwable, message = message)

    override fun w(tag: String?, throwable: Throwable?, message: () -> String) =
        at(tag).w(throwable = throwable, message = message)

    override fun e(tag: String?, throwable: Throwable?, message: () -> String) =
        at(tag).e(throwable = throwable, message = message)

    override fun a(tag: String?, throwable: Throwable?, message: () -> String) =
        at(tag).a(throwable = throwable, message = message)
}