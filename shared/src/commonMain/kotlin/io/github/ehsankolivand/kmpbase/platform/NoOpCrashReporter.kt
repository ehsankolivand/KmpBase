package io.github.ehsankolivand.kmpbase.platform

import io.github.ehsankolivand.kmpbase.core.platform.CrashReporter

class NoOpCrashReporter : CrashReporter {
    override fun recordException(throwable: Throwable, fatal: Boolean) = Unit
    override fun log(message: String) = Unit
    override fun setUserId(id: String?) = Unit
    override fun setKey(key: String, value: String) = Unit
    override fun setKey(key: String, value: Boolean) = Unit
    override fun setKey(key: String, value: Long) = Unit
    override fun setKey(key: String, value: Double) = Unit
}