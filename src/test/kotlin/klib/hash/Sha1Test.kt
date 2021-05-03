package klib.hash

import org.junit.Test
import java.util.Locale
import kotlin.test.assertEquals

class Sha1Test {
    private val hashedValue = "370C39711543CE2A36A91DBD9F4ECC3668C283C5"
    private val unhashedValue = "This is a hashing test"

    @Test
    fun `SHA1 from String`() {
        val sha = Sha1.hash(unhashedValue).hex

        assertEquals(hashedValue, sha.uppercase(Locale.getDefault()))
    }

    @Test
    fun `SHA1 from ByteArray`() {
        val sha = Sha1.hash(unhashedValue.toByteArray()).hex

        assertEquals(hashedValue, sha.uppercase(Locale.getDefault()))
    }
}
