/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.blockchain

import klib.extensions.times
import klib.extensions.ul
import klib.hash.Sha256

/**
 * Base Block that can be chained and use a custom Type
 *
 * @param T Custom Type. Must have toString() that stays consistent
 *
 * @since 6.0.0
 * @author Thomas Obernosterer
 */
open class BaseBlock<T>(
    var id: Int,
    var nonce: ULong = 0L.ul,
    var data: T,
    var prevBlock: String
) {
    /**
     * Calculate SHA256 Hash from Block
     *
     * @return Sha256 Hash of toString() as hex
     *
     * @since 6.0.0
     * @author Thomas Obernosterer
     */
    fun hash(): String {
        return Sha256.hash(toString()).hex
    }

    /**
     * Using a simple while loop the block can be mined
     *
     * @param zerosRequired Required count of leading Zeros (Default: 4)
     * @return Block when mined
     *
     * @since 6.0.0
     * @author Thomas Obernosterer
     */
    fun mine(zerosRequired: Int = 4): BaseBlock<T> {
        var hash = hash()
        while (!hash.startsWith("0" times zerosRequired)) {
            nonce++
            hash = hash()
        }
        return this
    }

    /**
     * Convert Block into Hash Ingest string
     *
     * @return id+prevBlockHash+data+nonce
     *
     * @since 6.0.0
     * @author Thomas Obernosterer
     */
    override fun toString(): String {
        return "$id+$prevBlock+$data+$nonce"
    }

    /**
     * Compare any Object to the Block
     *
     * Not equal when:
     *  - other is null
     *  - other is not a BaseBlock<*>
     *  - other.hash() != this.hash()
     *
     * Equal when:
     *  - other.hash() == this.hash()
     *
     * @since 6.0.0
     * @author Thomas Obernosterer
     */
    override fun equals(other: Any?): Boolean {
        // Not equal when other is null
        if (other == null) return false

        // Not equal when other is not a Block
        if (other !is BaseBlock<*>) return false

        // Compare the hashes
        return other.hash() == hash()
    }

    /**
     * Calculate a unique hash code
     *
     * Formula:
     *   hash = id
     *   hash = 31 * hash + nonce.hashCode()
     *   hash = 31 * hash + data.hashCode() or ((id + 5) * 3)
     *   hash = 31 * hash + prevBlock.hashCode()
     *
     * @since 6.0.0
     * @author Thomas Obernosterer
     */
    override fun hashCode(): Int {
        var result = id
        result = 31 * result + nonce.hashCode()
        result = 31 * result + (data?.hashCode() ?: ((id + 5) * 3))
        result = 31 * result + prevBlock.hashCode()
        return result
    }
}
