/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.functions

/**
 * Quicksort any kind of List
 *
 * @param items List to quicksort in
 *
 * @since 4.1.0
 * @author Thomas Obernosterer
 */
fun <T : Comparable<T>> listQuicksort(items: List<T>): List<T> {
    if (items.size < 2) {
        return items
    }
    val pivot = items[items.size / 2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }
    return listQuicksort(less) + equal + listQuicksort(greater)
}
