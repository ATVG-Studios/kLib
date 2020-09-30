package klib.extensions

import klib.exceptions.IncompatibleArrayLengthException
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TMap {
    @Test
    fun `Test merging with Arrays`() {
        val listA = mutableMapOf("a" to "b")
        val arrayA = arrayOf("c", "e", "g")
        val arrayB = arrayOf("d", "f", "h")

        listA.mergeArrays(arrayA, arrayB)

        assertEquals("{a=b, c=d, e=f, g=h}", listA.toString())
    }

    @Test
    fun `Test merging with Arrays of different size`() {
        val listA = mutableMapOf("a" to "b")
        val arrayA = arrayOf("c", "e", "g", "i", "k")
        val arrayB = arrayOf("d", "f", "h")

        assertFailsWith(IncompatibleArrayLengthException::class) {
            listA.mergeArrays(arrayA, arrayB)
        }
    }

    @Test
    fun `Test full merge`() {
        val listA: MutableMap<String, String> = mutableMapOf(
            "a" to "b",
            "c" to "d"
        )
        val listB: MutableMap<String, String> = mutableMapOf(
            "a" to "d",
            "e" to "f",
            "g" to "h"
        )

        listA.fullMerge(listB)

        assertEquals("{a=d, c=d, e=f, g=h}", listA.toString())
    }

    @Test
    fun `Test smart merge`() {
        val listA: MutableMap<String, String> = mutableMapOf(
            "a" to "b",
            "c" to "d"
        )
        val listB: MutableMap<String, String> = mutableMapOf(
            "a" to "d",
            "e" to "f",
            "g" to "h"
        )

        listA.smartMerge(listB)
        assertEquals("{a=b, c=d, e=f, g=h}", listA.toString())
    }

    @Test
    fun `Test smart merge with conversion`() {
        val listA: MutableMap<String, String> = mutableMapOf(
            "a" to "b",
            "c" to "d"
        )
        val listB: MutableMap<String, Any> = mutableMapOf(
            "a" to "d",
            "e" to "f",
            "g" to "h"
        )

        listA.smartMerge(listB) { it as String }
        assertEquals("{a=b, c=d, e=f, g=h}", listA.toString())
    }
}
