package klib.functions

/**
 * Binary Search any kind of Array
 *
 * @param array Array to search in
 * @param element Element to compare
 * @param start Start of the search
 * @param end End of the search
 *
 * @since 4.1.0
 * @author Thomas Obernosterer
 */
fun <T : Comparable<T>> arrayBinSearch(array: Array<T>, element: T, start: Int = 0, end: Int): Int {
    val middle = (start + end) / 2

    return when {
        start > end -> -1
        array[middle] == element -> middle
        array[middle] > element -> arrayBinSearch(array, element, start, middle - 1)
        array[middle] < element -> arrayBinSearch(array, element, middle + 1, end)
        else -> -1
    }
}
