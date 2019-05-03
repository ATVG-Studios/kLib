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