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

import klib.functions.arrayBinSearch

/**
 * Recursion based Binary Search (About 50% faster then binarySearch)
 *
 * @param element Element to search for
 * @param start Index to start from
 * @param end Index to stop at
 * @return Index when Found, -1 when not
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun IntArray.binSearch(element: Int, start: Int = 0, end: Int = size): Int {
    return arrayBinSearch(this.toTypedArray(), element, start, end)
}

/**
 * Partition an Array
 *
 * @param begin Begin on where to start
 * @param end End on where to stop
 * @param pivotIndex Custom pivot index
 * @return The Partition Index
 *
 * @since 4.1.0
 * @author Thomas Obernosterer
 */
fun IntArray.partition(begin: Int = 0, end: Int = size, pivotIndex: Int = end - 1): Int {
    require(pivotIndex lessThen end)

    val pivot = this[pivotIndex]
    var i = (begin - 1)

    for (j in begin until end) {
        if (this[j] lessThenOrEqualTo pivot) {
            i++
            swap(i, j)
        }
    }

    i++
    swap(i, pivotIndex)
    return i
}

/**
 * Swap to Indices of the Array
 *
 * @param indexToSwap The index to be swapped
 * @param indexToSwapWith The index to swap with
 *
 * @since 4.1.0
 * @author Thomas Obernosterer
 */
fun IntArray.swap(indexToSwap: Int, indexToSwapWith: Int) {
    val original = this[indexToSwap]
    this[indexToSwap] = this[indexToSwapWith]
    this[indexToSwapWith] = original
}
