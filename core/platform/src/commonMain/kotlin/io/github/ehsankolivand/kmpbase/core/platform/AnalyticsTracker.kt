package io.github.ehsankolivand.kmpbase.core.platform

interface AnalyticsTracker {
    fun track(event: AnalyticsEvent)
    fun setUserProperty(property: UserProperty)
    fun setUserId(id: String?)
    fun resetUser()
}