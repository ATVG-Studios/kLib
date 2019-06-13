package klib.extensions

/**
 * Recursion based Binary Search (About 50% faster then binarySearch)
 *
 * @param element Element to search for
 * @return Index when Found, -1 when not
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun IntArray.binSearch(element: Int, start: Int = 0, end: Int = size): Int {
    fun binSearch(array: IntArray, element: Int, left: Int, right: Int): Int {
        val middle = (left + right) / 2

        return when {
            left > right -> -1
            array[middle] == element -> middle
            array[middle] > element -> binSearch(array, element, left, middle - 1)
            array[middle] < element -> binSearch(array, element, middle + 1, right)
            else -> -1
        }
    }

    return binSearch(this, element, start, end)
}