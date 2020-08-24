package klib.net.socket

import java.io.File
import java.nio.CharBuffer
import java.util.Timer
import java.util.TimerTask

/**
 * Simple Read-Only UNIX inspired "Socket"
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
class KSocket {
    private lateinit var file: File
    private lateinit var buffer: CharBuffer
    private var fileName: String = ""
    private var timeout: Long = 0
    private var canReadFile: Boolean = false

    val data = buffer
    var canRead: Boolean
        get() = canReadFile
        set(value) = TODO("Cannot set value '$value' on read-only field 'canRead'")

    /**
     * Open up a new Socket
     *
     * For creation a CharBuffer has the be passed in. The reason for this is customization of Buffer-Size and where
     * the buffer is located (in class with default Buffer or in class-usage scope)
     *
     * @param file Socket File
     * @param timeout Timeout for Timed Reads (Default 25 ms)
     * @param buffer CharBuffer for output date (Default 1024)
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun open(file: String, timeout: Long = 25, buffer: CharBuffer = CharBuffer.allocate(1024)) {
        this.fileName = file
        this.timeout = timeout
        this.buffer = buffer

        this.file = File(fileName)

        this.canReadFile = this.file.exists() && this.file.canRead()
    }

    /**
     * Tries to read from the Socket
     *
     * If the read was successful, the data property is filled.
     *
     * @return The size of the read (-1 on error)
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun read(): Int {
        if (!isReadable()) {
            data.clear()
            return -1
        }

        return file.reader().read(buffer)
    }

    /**
     * Try to read every X milliseconds if it changed
     *
     * @param block Function that uses read data
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun readTimed(block: (size: Int, data: CharBuffer) -> Unit) {
        var lastTime = 0L
        var size: Int
        var lastMod: Long
        val timer = Timer()
        timer.scheduleAtFixedRate(
            object : TimerTask() {
                override fun run() {
                    lastMod = file.lastModified()
                    if (lastMod != lastTime) {
                        lastTime = lastMod
                        size = read()
                        block(size, data)
                    }
                }
            },
            timeout, timeout
        )
    }

    private fun isReadable(): Boolean {
        this.canReadFile = this.file.exists() && this.file.canRead()
        return this.canReadFile
    }
}
