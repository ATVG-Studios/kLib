package klib

import klib.exceptions.InvalidTypeException
import org.junit.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class SemVerTest {
    @Test
    fun `SemVer is able to parse a valid Version string`() {
        val sv = SemVer.parse("1.3.4-rc+b100")
        assertTrue {
            sv.major == 1 && sv.minor == 3 && sv.patch == 4 && sv.preRelease == "rc" && sv.buildMetadata == "b100"
        }
    }

    @Test
    fun `SemVer throws a InvalidTypeException when trying to parse an invalid Version string`() {
        assertFailsWith<InvalidTypeException> {
            SemVer.parse("1.3.4_-rc+b100")
        }
    }
}
