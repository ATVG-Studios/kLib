package klib.hash

import java.security.MessageDigest

/**
 * Common Hashing Interface
 *
 * @since 0.1.2
 * @author Thomas Obernosterer
 */
interface Hasher {
    /**
     * Hash byte array with algo
     *
     * @param data
     * @param algo
     * @return
     *
     * @since 0.1.3
     * @author Thomas Obernosterer
     */
    fun hash(data: ByteArray, algo: String): HashResult {
        val md = MessageDigest.getInstance(algo)
        val digest = md.digest(data)
        return HashResult(hex = digest.fold("") { str, it -> str + "%02x".format(it) }, algo = algo)
    }
}
