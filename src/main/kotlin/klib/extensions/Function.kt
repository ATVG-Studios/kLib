package klib.extensions

import java.util.Timer
import java.util.TimerTask

/**
 * Execute function every x milliseconds
 *
 * @param delay Every x millis
 *
 * @since 3.0.0
 * @author Thomas Obernosterer
 */
infix fun (() -> Unit).every(delay: Long) {
    val timer = Timer()
    timer.scheduleAtFixedRate(
        object : TimerTask() {
            override fun run() {
                try {
                    this@every()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        },
        0,
        delay
    )
}
