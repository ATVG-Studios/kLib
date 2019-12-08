package klib.hash

import java.nio.charset.Charset

/**
 * Custom Sha256 Hasher-Interface Implementation
 *
 * @since 4.1.0
 * @author Thomas Obernosterer
 */
object Sha512 : Hasher {
    /**
     * Charset to use
     *
     * @see Charset.defaultCharset()
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    var defaultCharset: Charset = Charset.defaultCharset()

    /**
     * Hash a byte array in SHA256
     *
     * @param data
     * @return
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun hash(data: ByteArray): HashResult = super.hash(data, "SHA-512")

    /**
     * Hash a string in SHA256 (Use defaultCharset)
     *
     * @param data
     * @return
     * @see defaultCharset
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun hash(data: String): HashResult = super.hash(data.toByteArray(defaultCharset), "SHA-512")
}