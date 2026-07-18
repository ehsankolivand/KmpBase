package io.github.ehsankolivand.kmpbase.core.testing

import io.github.ehsankolivand.kmpbase.core.platform.AnalyticsEvent
import io.github.ehsankolivand.kmpbase.core.platform.AnalyticsTracker
import io.github.ehsankolivand.kmpbase.core.platform.UserProperty

class FakeAnalyticsTracker : AnalyticsTracker {
    val trackedEvents = mutableListOf<AnalyticsEvent>()
    val userProperties = mutableListOf<UserProperty>()
    var lastUserId: String? = null

    override fun track(event: AnalyticsEvent) {
        trackedEvents += event
    }

    override fun setUserProperty(property: UserProperty) {
        userProperties += property
    }

    override fun setUserId(id: String?) {
        lastUserId = id
    }

    override fun resetUser() {
        lastUserId = null
        userProperties.clear()
    }
}