package com.atvgstudios.klib.objects.hash

import com.atvgstudios.klib.interfaces.Hasher
import com.atvgstudios.klib.types.hash.HashResult
import java.nio.charset.Charset

/**
 * Custom Sha256 Hasher-Interface Implementation
 *
 * @since 0.1.2
 * @author Thomas Obernosterer
 */
object Sha256 : Hasher {
    /**
     * Charset to use
     *
     * @see Charset.defaultCharset()
     *
     * @since 0.1.2
     * @author Thomas Obernosterer
     */
    var defaultCharset: Charset = Charset.defaultCharset()

    /**
     * Hash a byte array in SHA256
     *
     * @param data
     * @return
     *
     * @since 0.1.2
     * @author Thomas Obernosterer
     */
    fun hash(data: ByteArray): HashResult = super.hash(data, "SHA-256")

    /**
     * Hash a string in SHA256 (Use defaultCharset)
     *
     * @param data
     * @return
     * @see defaultCharset
     *
     * @since 0.1.2
     * @author Thomas Obernosterer
     */
    fun hash(data: String): HashResult = super.hash(data.toByteArray(defaultCharset), "SHA-256")
}