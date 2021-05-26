/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.uuid

import java.util.UUID

/**
 * Custom UUID Wrapper
 *
 * @see java.util.UUID
 *
 * @since 0.1.0
 * @author Thomas Obernosterer
 */
object UniqueID {
    /**
     * Simple property wrapper around UUID
     *
     * @see java.util.UUID
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    val random
        get() = UUID.randomUUID().toString()

    /**
     * Publicly Read-Only last id created with new()
     * @see new()
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    var lastId: String = ""
        private set

    /**
     * Get a new Random UUID and store it in lastId
     *
     * @return
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    fun new(): String {
        lastId = random
        return lastId
    }
}
