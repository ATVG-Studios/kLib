package klib.extensions

/**
 * Sorting a list using quicksort by returning the sorted list
 *
 * @see quicksort
 *
 * @since 0.2.2
 * @author Thomas Obernosterer
 */
fun <T: Comparable<T>> List<T>.quicksort(): List<T> {
    fun quicksort(items: List<T>): List<T> {
        if(items.size < 2){
            return items
        }
        val pivot = items[items.size / 2]
        val equal = items.filter { it == pivot }
        val less = items.filter { it < pivot }
        val greater = items.filter { it > pivot}
        return quicksort(less) + equal + quicksort(greater)
    }
    return quicksort(this)
}