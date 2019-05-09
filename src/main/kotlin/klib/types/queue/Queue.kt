package klib.types.queue

import klib.typealiases.Function
import java.util.Timer
import java.util.TimerTask

/**
 * Custom Queue for Functions
 *
 * @see Function
 *
 * @since 0.1.5 (Experimental)
 * @since 0.2.1
 * @author Nils Rider
 */
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

    /**
     * Add new functions using "queue += {}"
     *
     * @param function The function to run
     *
     * @see Function
     *
     * @since 0.2.2
     * @author Thomas Obernosterer
     */
    operator fun plusAssign(function: Function) {
        queueList.add(function)
    }

    /**
     * Run the top of the queue
     *
     * @since 0.2.2
     * @author Thomas Obernosterer
     */
    operator fun invoke() {
        if (!isEmpty)
            dequeue().invoke()
    }

    /**
     * Start a execution daemon that executes the queue all x millis
     *
     * @param millis Interval between executions
     *
     * @since 0.2.2
     * @author Thomas Obernosterer
     */
    fun startTimedExecution(millis: Long) {
        val timerTask = object : TimerTask() {
            override fun run() {
                if (!isEmpty)
                    dequeue().invoke()
            }
        }
        val timer = Timer("klib.queue.task", false)
        timer.schedule(timerTask, 0, millis)
    }
}