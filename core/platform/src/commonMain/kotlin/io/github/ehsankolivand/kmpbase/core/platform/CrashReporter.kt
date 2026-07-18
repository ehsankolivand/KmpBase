package io.github.ehsankolivand.kmpbase.core.platform

interface CrashReporter {
    fun recordException(throwable: Throwable, fatal: Boolean = false)
    fun log(message: String)
    fun setUserId(id: String?)
    fun setKey(key: String, value: String)
    fun setKey(key: String, value: Boolean)
    fun setKey(key: String, value: Long)
    fun setKey(key: String, value: Double)
}