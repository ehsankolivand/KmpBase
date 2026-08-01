package io.github.ehsankolivand.kmpbase.platform

import io.github.ehsankolivand.kmpbase.core.platform.AnalyticsEvent
import io.github.ehsankolivand.kmpbase.core.platform.AnalyticsTracker
import io.github.ehsankolivand.kmpbase.core.platform.UserProperty

class NoOpAnalyticsTracker : AnalyticsTracker {
    override fun track(event: AnalyticsEvent) = Unit
    override fun setUserProperty(property: UserProperty) = Unit
    override fun setUserId(id: String?) = Unit
    override fun resetUser() = Unit
}