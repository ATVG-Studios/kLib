/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2022 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2022 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.blockchain

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
    var data: T,
    var prevBlock: String
) {
    val hash: String

    init {
        hash = calculateHash()
    }

    /**
     * Calculate SHA256 Hash from Block
     *
     * @return Sha256 Hash of toString() as hex
     *
     * @since 6.0.0
     * @author Thomas Obernosterer
     */
    fun calculateHash(): String {
        return Sha256.hash(toString()).hex
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
        return "$id:$prevBlock:$data"
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
        return other.hash == hash
    }

    /**
     * Calculate a unique hash code
     *
     * Formula:
     *   hash = id
     *   hash = 31 * hash + data.hashCode() or ((id + 5) * 3)
     *   hash = 31 * hash + prevBlock.hashCode()
     *
     * @since 6.0.0
     * @author Thomas Obernosterer
     */
    override fun hashCode(): Int {
        var result = id
        result = 31 * result + (data?.hashCode() ?: ((id + 5) * 3))
        result = 31 * result + prevBlock.hashCode()
        return result
    }
}
