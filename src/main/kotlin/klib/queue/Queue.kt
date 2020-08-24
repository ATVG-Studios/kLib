package klib.queue

import java.util.Timer
import java.util.TimerTask

/**
 * Custom Queue for Functions
 *
 * @see Function
 *
 * @since 0.1.5 (Experimental)
 * @since 0.2.1
 * @since 5.1.0 (Deprecated)
 * @author Nils Rider
 */
@Deprecated(
    message = "Due to no recent use cases for this Class it has been marked as deprecated." +
        "It will be removed with release 6.0.0 (Probably early 2021)" +
        "If you wish to have us keep it, please respond to https://beeit.org/klib-i32",
    level = DeprecationLevel.WARNING
)
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
     * @param func The Function to add
     *
     * @see Function
     *
     * @since 0.1.5
     * @author Nils Rider
     */
    fun enqueue(func: Function) {
        queueList.add(func)
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
     * @param dieAfterLast If true kills the timer if the queue is empty (Default: True)
     *
     * @since 0.2.2
     * @author Thomas Obernosterer
     */
    fun startTimedExecution(millis: Long, dieAfterLast: Boolean = true) {
        val timer = Timer("klib.queue.task", false)
        val timerTask = object : TimerTask() {
            override fun run() {
                if (!isEmpty)
                    dequeue().invoke()
                if (isEmpty && dieAfterLast)
                    timer.cancel()
            }
        }
        timer.schedule(timerTask, 0, millis)
    }
}
