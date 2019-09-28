package klib.net.socket

import java.io.File
import java.nio.CharBuffer
import java.util.Timer
import java.util.TimerTask

class KSocket {
    private lateinit var file: File
    private lateinit var buffer: CharBuffer
    private var fileName: String = ""
    private var timeout: Long = 0
    private var canReadFile: Boolean = false

    val data = buffer
    var canRead: Boolean
        get() = canReadFile
        set(value) = TODO()

    fun open(file: String, timeout: Long = 25, buffer: CharBuffer = CharBuffer.allocate(1024)) {
        this.fileName = file
        this.timeout = timeout
        this.buffer = buffer

        this.file = File(fileName)

        this.canReadFile = this.file.exists() && this.file.canRead()
    }

    fun read(): Int {
        if (!isReadable()) {
            data.clear()
            return -1
        }

        return file.reader().read(buffer)
    }

    fun readTimed(block: (size: Int, data: CharBuffer) -> Unit) {
        var lastTime = 0L
        var size = 0
        var lastMod = 0L
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                lastMod = file.lastModified()
                if (lastMod != lastTime) {
                    lastTime = lastMod
                    size = read()
                    block(size, data)
                }
            }
        }, timeout, timeout)
    }

    private fun isReadable(): Boolean {
        this.canReadFile = this.file.exists() && this.file.canRead()
        return this.canReadFile
    }
}