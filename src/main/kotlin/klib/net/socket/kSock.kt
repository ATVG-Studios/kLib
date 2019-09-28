package klib.net.socket

import klib.extensions.reset
import klib.functions.currentMillis
import java.io.File
import java.io.InputStreamReader
import java.util.Timer
import java.util.TimerTask

/**
 * Simple but useful one-way IPC socket
 *
 * @since 3.0.0
 * @author Thomas Obernosterer
 */
@Deprecated("kSock has been replaced by KSocket", ReplaceWith("KSocket", "klib.net.socket.KSocket"), DeprecationLevel.ERROR)
object kSock {
    private var id = 0L

    /**
     * Open a timed one-way connection
     *
     * @param name File path of socket
     * @param timed Refresh seconds
     * @param block Refresh-Listener (Based on modify date)
     *
     * @since 3.0.0
     * @author Thomas Obernosterer
     */
    fun open(name: String = "/tmp/ksock-$id.sock", timed: Long = 100, block: (InputStreamReader) -> Unit) {
        id++

        // Store last modified date of file
        var lastTime = currentMillis()
        val file = File(name)

        // Reset the file
        file.reset()

        // Create and start Timer
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val lastMod = file.lastModified()
                if (lastMod != lastTime) {
                    lastTime = lastMod
                    block(file.reader())
                    file.reset()
                }
            }
        }, timed, timed)
    }
}