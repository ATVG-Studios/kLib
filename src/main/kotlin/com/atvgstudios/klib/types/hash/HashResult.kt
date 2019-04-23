package com.atvgstudios.klib.types.hash

/**
 * HashResults gets return from the Hasher with the Hex Hash and the used Algorithm
 *
 * @param hex
 * @param algo
 */
class HashResult(val hex: String, val algo: String) {
    /**
     * Returns Hex Value
     *
     * @return
     */
    override fun toString(): String = hex
}