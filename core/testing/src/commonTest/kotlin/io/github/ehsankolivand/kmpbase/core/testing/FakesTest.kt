package io.github.ehsankolivand.kmpbase.core.testing

import io.github.ehsankolivand.kmpbase.core.platform.Flag
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.minutes
import kotlin.uuid.ExperimentalUuidApi

class FakesTest {

    @Test
    fun testClock_advances_only_when_told() {
        val clock = TestClock()
        val start = clock.now()

        clock.advanceBy(30.minutes)

        assertEquals(30.minutes, clock.now() - start)
    }

    @OptIn(ExperimentalUuidApi::class)
    @Test
    fun fakeUuidGenerator_produces_a_deterministic_sequence() {
        val generator = FakeUuidGenerator()

        val first = generator.generate()
        val second = generator.generate()

        assertNotEquals(first, second)
        assertEquals(first, FakeUuidGenerator().generate())
    }

    @Test
    fun fakeCrashReporter_records_what_it_is_given() {
        val reporter = FakeCrashReporter()
        val boom = IllegalStateException("boom")

        reporter.recordException(boom)

        assertEquals(1, reporter.recordedExceptions.size)
        assertEquals(boom, reporter.recordedExceptions.first())
    }

    @Test
    fun fakeFeatureFlagsReflectsSetValueInBothReadPaths() = runTest {
        val flag = Flag.Bool(key = "new_checkout", default = false)
        val flags = FakeFeatureFlags()

        flags.setFlag(flag, true)

        assertTrue(flags.bool(flag))
        assertTrue(flags.observe(flag).first())
    }
}