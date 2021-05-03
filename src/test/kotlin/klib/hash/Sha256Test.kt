package klib.hash

import org.junit.Test
import java.util.Locale
import kotlin.test.assertEquals

class Sha256Test {
    private val hashedValue = "43541CC5E3E1F5BF3918DD77AACDD5AB94CCCDA706EF2656674569CE02CE6061"
    private val unhashedValue = "This is a hashing test"

    @Test
    fun `SHA256 from String`() {
        val sha = Sha256.hash(unhashedValue).hex

        assertEquals(hashedValue, sha.uppercase(Locale.getDefault()))
    }

    @Test
    fun `SHA256 from ByteArray`() {
        val sha = Sha256.hash(unhashedValue.toByteArray()).hex

        assertEquals(hashedValue, sha.uppercase(Locale.getDefault()))
    }
}
