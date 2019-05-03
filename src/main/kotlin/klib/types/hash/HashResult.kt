package klib.types.hash

/**
 * HashResults gets return from the Hasher with the Hex Hash and the used Algorithm
 *
 * @param hex
 * @param algo
 *
 * @since 0.1.2
 * @author Thomas Obernosterer
 */
class HashResult(val hex: String, val algo: String) {
    /**
     * Returns Hex Value
     *
     * @return
     *
     * @since 0.1.2
     * @author Thomas Obernosterer
     */
    override fun toString(): String = hex
}