/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.extensions

import org.junit.Test

class TList {
    @Test
    fun quicksort() {
        val data = listOf("Tim", "Steve", "Zack", "Adam", "John", "Peter", "Clark")
        val data2 = data.quicksort()
        assert(data2 == listOf("Adam", "Clark", "John", "Peter", "Steve", "Tim", "Zack"))
    }
}
