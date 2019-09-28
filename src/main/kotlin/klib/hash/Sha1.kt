package klib.hash

import java.nio.charset.Charset

/**
 * Custom Sha1 Hasher-Interface Implementation
 *
 * @since 2.0.0
 * @author Thomas Obernosterer
 */
object Sha1 : Hasher {
    /**
     * Charset to use
     *
     * @see Charset.defaultCharset()
     *
     * @since 2.0.0
     * @author Thomas Obernosterer
     */
    var defaultCharset: Charset = Charset.defaultCharset()

    /**
     * Hash a byte array in SHA1
     *
     * @param data
     * @return
     *
     * @since 2.0.0
     * @author Thomas Obernosterer
     */
    fun hash(data: ByteArray): HashResult = super.hash(data, "SHA-1")

    /**
     * Hash a string in SHA1 (Use defaultCharset)
     *
     * @param data
     * @return
     * @see defaultCharset
     *
     * @since 2.0.0
     * @author Thomas Obernosterer
     */
    fun hash(data: String): HashResult = super.hash(data.toByteArray(defaultCharset), "SHA-1")
}