package klib.extensions

import org.junit.Test

fun b(num: Int): Byte = num.toByte()

class TByte {
    @Test
    fun mul() {
        val byteResult = b(0x02) mul b(0x02)
        assert(byteResult == b(0x04))
    }
}