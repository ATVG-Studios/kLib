package klib.word

import kotlin.experimental.xor

/**
 * Custom implementation of Word datatype with 4 Bytes
 *
 * @param w0
 * @param w1
 * @param w2
 * @param w3
 *
 * @since 0.1.0
 * @author Thomas Obernosterer
 */
data class Word(val w0: Byte, val w1: Byte, val w2: Byte, val w3: Byte) {
    companion object {
        /**
         * Creates a empty Word
         *
         * @return
         *
         * @since 0.1.0
         * @author Thomas Obernosterer
         */
        fun empty() = Word(0, 0, 0, 0)

        /**
         * Converts a ByteArray to Word
         *
         * @param array
         * @return
         *
         * @since 0.1.0
         * @author Thomas Obernosterer
         */
        fun fromByteArray(array: ByteArray): Word {
            return Word(
                array[0],
                array[1],
                array[2],
                array[3]
            )
        }
    }

    /**
     * Custom toString
     *
     * @return
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    override fun toString(): String {
        val h0 = String.format("%02x", w0)
        val h1 = String.format("%02x", w1)
        val h2 = String.format("%02x", w2)
        val h3 = String.format("%02x", w3)

        return "$h0 $h1 $h2 $h3"
    }

    /**
     * Xor two Words
     *
     * @param word
     * @return
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    infix fun xor(word: Word): Word {
        return Word(
            w0 xor word.w0,
            w1 xor word.w1,
            w2 xor word.w2,
            w3 xor word.w3
        )
    }

    /**
     * Convert Word to ByteArray (Inverse of fromByteArray)
     *
     * @see fromByteArray
     * @return
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    fun toByteArray() = byteArrayOf(w0, w1, w2, w3)
}
