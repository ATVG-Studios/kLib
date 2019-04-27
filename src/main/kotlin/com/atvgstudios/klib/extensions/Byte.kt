package com.atvgstudios.klib.extensions

/**
 * Byte-Byte multiply
 *
 * @param b
 * @return
 *
 * @since 0.1.0
 * @author Thomas Obernosterer
 */
infix fun Byte.mul(b: Byte): Byte {
    var tmpA = this.toInt()
    var tmpB = b.toInt()

    var p = 0
    var hiBitSet: Int

    for (i in 0 until 8) {
        if ((tmpB and 0x01) == 1) {
            p = (p xor tmpA) and 0xff
        }

        hiBitSet = tmpA and 0x80
        tmpA = tmpA shl 1

        if (hiBitSet == 0x80) {
            tmpA = tmpA xor 0x1b
        }

        tmpB = (tmpB shr 1) and 0x7f
    }

    return p.toByte()
}