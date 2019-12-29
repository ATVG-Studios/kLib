package klib.extensions

import klib.functions.arrayBinSearch
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
    fun quicksort(items: List<T>): List<T> {
        if (items.size < 2) {
            return items
        }
        val pivot = items[items.size / 2]
        val equal = items.filter { it == pivot }
        val less = items.filter { it < pivot }
        val greater = items.filter { it > pivot }
        return quicksort(less) + equal + quicksort(greater)
    }
    return quicksort(this)
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
