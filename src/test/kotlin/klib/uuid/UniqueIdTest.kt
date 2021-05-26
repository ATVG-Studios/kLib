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

import kotlin.test.Test
import kotlin.test.assertEquals

class UniqueIdTest {
    @Test
    fun `Get random UUID 4 with new()`() {
        val newUUID = UniqueID.new()
        assert(newUUID.isNotEmpty())
    }

    @Test
    fun `Get random UUID 4 with random`() {
        val newUUID = UniqueID.random
        assert(newUUID.isNotEmpty())
    }

    @Test
    fun `Get last random UUID 4`() {
        val newUUID = UniqueID.new()
        val lastUUID = UniqueID.lastId
        assertEquals(newUUID, lastUUID)
    }
}
