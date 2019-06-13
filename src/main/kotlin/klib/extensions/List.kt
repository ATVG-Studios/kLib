package klib.extensions

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