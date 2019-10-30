package klib.extensions

import klib.files.Directory
import java.io.File

/**
 * Swap two indexes in a MutableList
 *
 * @param index The first index to switch
 * @param with The second index to switch
 * @throws IllegalArgumentException Thrown if index >= size, index < 0, with >= size, with < 0 or index == with
 *
 * @since 0.1.4
 * @author Thomas Obernosterer
 */
fun <T> MutableList<T>.swap(index: Int, with: Int) {
    if (index >= size || index < 0 || with >= size || with < 0 || index == with) throw IllegalArgumentException()

    val tmp = this[index]
    this[index] = this[with]
    this[with] = tmp
}

/**
 * Replace all x with n
 *
 * @param value The value to replace
 * @param with The value to replace with
 * @throws IllegalArgumentException Thrown if value == with
 *
 * @since 0.1.4
 * @author Thomas Obernosterer
 */
fun <T> MutableList<T>.replaceAll(value: T, with: T) {
    if (value == with) throw IllegalArgumentException()

    while (contains(value)) {
        this[indexOf(value)] = with
    }
}

/**
 * Removes and returns the last element; Mutates the List!
 *
 * @return The poped element
 * @throws UnsupportedOperationException If the list is empty
 *
 * @source This feature was inspired by QList::pop_back() from Qt 5.12.3
 *
 * @since 0.1.4
 * @author Thomas Obernosterer
 */
fun <T> MutableList<T>.popEnd(): T {
    if (size <= 0) throw UnsupportedOperationException("The list cannot be empty")

    val last = this[size - 1]
    this.removeAt(size - 1)
    return last
}

/**
 * Removes and returns the first element; Mutates the List!
 *
 * @return The poped element
 * @throws UnsupportedOperationException If the list is empty
 *
 * @source This feature was inspired by QList::pop_front() from Qt 5.12.3
 *
 * @since 0.1.4
 * @author Thomas Obernosterer
 */
fun <T> MutableList<T>.popBegin(): T {
    if (size <= 0) throw java.lang.UnsupportedOperationException("The list cannot be empty")

    val last = this[0]
    this.removeAt(0)
    return last
}

/**
 * Add a item to the begin of the list
 *
 * @param value The value to prepend
 *
 * @source This feature was inspired by QList::prepend() from Qt 5.12.3
 *
 * @since 0.1.4
 * @author Thomas Obernosterer
 */
fun <T> MutableList<T>.prepend(value: T) {
    this.add(0, value)
}

/**
 * Sorting a list using quicksort by modifying the list
 *
 * @see quicksort
 *
 * @since 0.2.2
 * @author Thomas Obernosterer
 */
fun <T : Comparable<T>> MutableList<T>.quicksort() {
    fun quicksort(items: List<T>): MutableList<T> {
        if (items.size < 2) {
            return items.toMutableList()
        }
        val pivot = items[items.size / 2]
        val equal = items.filter { it == pivot }
        val less = items.filter { it < pivot }
        val greater = items.filter { it > pivot }
        return (quicksort(less) + equal + quicksort(greater)).toMutableList()
    }
    val orig = this.toList()
    val res = quicksort(orig)
    this.clear()
    this.addAll(res)
}

/**
 * Convert List A to List B with Type E
 *
 * @param convert Method to convert type T to E
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun <T, E> MutableList<T>.toListWithConvert(convert: (T) -> E): List<E> {
    val list: MutableList<E> = ArrayList()

    this.forEach {
        list.add(convert(it))
    }

    return list
}

/**
 * Replace all in all file contents
 *
 * @param search The string to replace
 * @param replace The string to replace with
 * @param ignoreCase Ignore case on search
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
fun MutableList<File>.replaceAllOf(search: String, replace: String, ignoreCase: Boolean = false) {
    val content = this.readAll().toMutableMap()

    content.forEach {
        while(it.value.contains(search, ignoreCase)) {
            content[it.key] = it.value.replace(search, replace, ignoreCase)
        }
    }

    this.writeAll(content)
}