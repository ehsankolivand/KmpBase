package io.github.ehsankolivand.kmpbase.core.testing

import io.github.ehsankolivand.kmpbase.core.platform.UuidGenerator
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class FakeUuidGenerator(seed: Long = 0L) : UuidGenerator {
    private var counter = seed

    @OptIn(ExperimentalUuidApi::class)
    override fun generate(): Uuid {
        val next = counter++
        return Uuid.fromLongs(0L, next)
    }
}