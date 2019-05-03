package klib.types.queue

import klib.typealiases.Function

/**
 * Custom Queue for Functions
 *
 * @see Function
 *
 * @since 0.1.5 (Experimental)
 * @author Nils Rider
 */
@klib.annotations.Experimental
class Queue {
    private var queueList: MutableList<Function> = ArrayList()

    /**
     * Find out if the queue is empty or not
     *
     * @since 0.1.5
     * @author Nils Rider
     */
    val isEmpty: Boolean
        get() = queueList.size <= 0

    /**
     * This is a mirror of isEmpty
     *
     * @see isEmpty
     *
     * @since 0.1.5
     * @author Nils Rider
     */
    val hasItems: Boolean
        get() = queueList.size >= 1

    /**
     * Add a function to the queue
     *
     * @param x The Function to add
     *
     * @see Function
     *
     * @since 0.1.5
     * @author Nils Rider
     */
    fun enqueue(x: Function) {
        queueList.add(x)
    }

    /**
     * Get and remove the first function in the queue
     *
     * @return The first function in the queue
     *
     * @see Function
     *
     * @since 0.1.5
     * @author Nils Rider
     */
    fun dequeue(): Function {
        if (isEmpty) throw UnsupportedOperationException("Cannot dequeue a empty queue")

        val x = queueList.first()
        queueList.removeAt(0)
        return x
    }

    /**
     * Get and remove all functions from the queue
     *
     * @return A List<Function> with all functions of the queue
     *
     * @see Function
     *
     * @since 0.1.5
     * @author Nils Rider
     */
    fun dequeueAll(): List<Function> {
        if (isEmpty) throw UnsupportedOperationException("Cannot dequeue a empty queue")

        val x: List<Function> = queueList.toTypedArray().clone().toList()
        queueList.clear()
        return x
    }
}