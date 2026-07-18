package io.github.ehsankolivand.kmpbase.core.testing

import io.github.ehsankolivand.kmpbase.core.platform.CrashReporter

class FakeCrashReporter : CrashReporter {
    val recordedExceptions = mutableListOf<Throwable>()
    val logs = mutableListOf<String>()
    var lastUserId: String? = null
    val keys = mutableMapOf<String, Any>()

    override fun recordException(throwable: Throwable, fatal: Boolean) {
        recordedExceptions += throwable
    }

    override fun log(message: String) {
        logs += message
    }

    override fun setUserId(id: String?) {
        lastUserId = id
    }

    override fun setKey(key: String, value: String) { keys[key] = value }
    override fun setKey(key: String, value: Boolean) { keys[key] = value }
    override fun setKey(key: String, value: Long) { keys[key] = value }
    override fun setKey(key: String, value: Double) { keys[key] = value }
}