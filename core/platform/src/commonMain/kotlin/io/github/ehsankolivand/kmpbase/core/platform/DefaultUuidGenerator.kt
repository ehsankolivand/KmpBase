package io.github.ehsankolivand.kmpbase.core.platform

import kotlin.uuid.Uuid

class DefaultUuidGenerator : UuidGenerator {
    override fun generate(): Uuid = Uuid.random()
}