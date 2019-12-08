package klib.extensions

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