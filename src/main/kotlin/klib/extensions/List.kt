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
import klib.functions.listQuicksort
import java.io.File

/**
 * Sorting a list using quicksort by returning the sorted list
 *
 * @see quicksort
 *
 * @since 0.2.2
 * @author Thomas Obernosterer
 */
fun <T : Comparable<T>> List<T>.quicksort(): List<T> {
    return listQuicksort(this)
}

/**
 * Convert List A to List B with Type E
 *
 * @param convert Method to convert type T to E
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun <T, E> List<T>.toListWithConvert(convert: (T) -> E): List<E> {
    val list: MutableList<E> = ArrayList()

    this.forEach {
        list.add(convert(it))
    }

    return list
}

/**
 * Recursion based Binary Search (About 50% faster then binarySearch)
 *
 * @param element Element to search for
 * @param start Index to start from
 * @param end Index to stop at
 * @return Index when Found, -1 when not
 *
 * @since 3.2.0
 * @author Thomas Obernosterer
 */
inline fun <reified T : Comparable<T>> List<T>.binSearch(element: T, start: Int = 0, end: Int = size): Int {
    return arrayBinSearch(this.toTypedArray(), element, start, end)
}

/**
 * Read all files contents
 *
 * @return HashMap with file name and content
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
fun List<File>.readAll(): HashMap<String, String> {
    val content = HashMap<String, String>()

    this.forEach {
        content[it.name] = it.readText()
    }

    return content
}

/**
 * Write all files contents
 *
 * @param content HashMap with file name and content
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
fun List<File>.writeAll(content: HashMap<String, String>) {
    writeAll(content.toMutableMap())
}

/**
 * Write all files contents
 *
 * @param content MutableMap with file name and content
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
fun List<File>.writeAll(content: MutableMap<String, String>) {
    this.forEach {
        if (it.name in content) {
            it.writeText(content[it.name] ?: "")
        }
    }
}
