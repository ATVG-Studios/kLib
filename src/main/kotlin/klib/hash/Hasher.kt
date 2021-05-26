/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

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
