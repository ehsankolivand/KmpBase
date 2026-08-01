package io.github.ehsankolivand.kmpbase.core.platform

import kotlin.time.Clock
import kotlin.time.Instant
import kotlinx.datetime.TimeZone

class DefaultClockSeam : ClockSeam {
    override fun now(): Instant = Clock.System.now()
    override fun currentZone(): TimeZone = TimeZone.currentSystemDefault()
}