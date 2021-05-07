package klib.text

import klib.functions.kstring
import org.junit.Test
import kotlin.test.assertEquals

class KStringTest {
    @Test
    fun `Build String 1`() {
        val wantedString = "Hello!\nHow are you doing?\nAny news?"

        val buildString = kstring {
            line("Hello!")
            line("How are you doing?")
            text("Any news?")
        }

        assertEquals(wantedString, buildString)
    }

    @Test
    fun `Build String 2`() {
        val wantedString = "Hello!\nHow are you doing?\nAny news?"

        val stringBuilder = KString()

        stringBuilder + "Hello!"
        stringBuilder + '\n'

        stringBuilder += "How are you doing?"
        stringBuilder += '\n'
        stringBuilder += "Any news?"

        assertEquals(wantedString, stringBuilder.toString())
    }


    @Test
    fun `Build String 3`() {
        val wantedString = "Hello!\nHow are you doing?\nAny news?"

        val buildString = kstring {
            + "Hello!"
            + '\n'

            line("How are you doing?")
            text("Any news?")
        }

        assertEquals(wantedString, buildString)
    }
}