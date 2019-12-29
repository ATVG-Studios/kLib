package klib.functions

/**
 * Quicksort any kind of List
 *
 * @param items List to quicksort in
 *
 * @since 4.1.0
 * @author Thomas Obernosterer
 */
fun <T: Comparable<T>> listQuicksort(items: List<T>): List<T> {
    if (items.size < 2) {
        return items
    }
    val pivot = items[items.size / 2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }
    return listQuicksort(less) + equal + listQuicksort(greater)
}