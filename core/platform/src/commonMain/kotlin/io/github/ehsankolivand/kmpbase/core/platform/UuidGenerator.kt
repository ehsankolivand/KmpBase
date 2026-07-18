package io.github.ehsankolivand.kmpbase.core.platform

import kotlin.uuid.Uuid

interface UuidGenerator {
    fun generate(): Uuid
}