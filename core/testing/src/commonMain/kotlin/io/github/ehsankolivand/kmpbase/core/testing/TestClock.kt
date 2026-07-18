package io.github.ehsankolivand.kmpbase.core.testing

import io.github.ehsankolivand.kmpbase.core.platform.ClockSeam
import kotlinx.datetime.TimeZone
import kotlin.time.Duration
import kotlin.time.Instant

class TestClock(
    private var current: Instant = Instant.fromEpochSeconds(0),
    private val zone: TimeZone = TimeZone.UTC,
) : ClockSeam {
    override fun now(): Instant = current
    override fun currentZone(): TimeZone = zone

    fun advanceBy(duration: Duration) {
        current += duration
    }

    fun setNow(instant: Instant) {
        current = instant
    }
}