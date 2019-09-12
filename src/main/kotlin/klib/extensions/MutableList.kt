package klib.extensions

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
fun <T : Comparable<T>> MutableList<T>.binSearch(element: T, start: Int = 0, end: Int = size): Int {
    fun binSearch(array: List<T>, element: T, left: Int, right: Int): Int {
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