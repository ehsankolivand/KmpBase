package io.github.ehsankolivand.kmpbase.core.platform

import kotlinx.datetime.TimeZone
import kotlin.time.Instant

interface ClockSeam {
    fun now(): Instant
    fun currentZone(): TimeZone
}