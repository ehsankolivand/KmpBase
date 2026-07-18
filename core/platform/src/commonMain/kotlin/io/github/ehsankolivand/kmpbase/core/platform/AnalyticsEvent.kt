package io.github.ehsankolivand.kmpbase.core.platform

interface AnalyticsEvent {
    val name: String
    val params: AnalyticsParams
}

interface AnalyticsParams {
    data object None : AnalyticsParams
}

interface UserProperty {
    val key: String
    val value: String?
}