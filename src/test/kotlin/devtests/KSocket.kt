package devtests

import klib.net.socket.KSocket

fun main() {
    useWhileLoop()
    useTimedLoop()
}

fun useWhileLoop() {
    val socket = KSocket()
    socket.open("/tmp/kotlin-socket.sk")

    while(socket.canRead) {
        if(socket.read() >= 1) {
            println(socket.data)
        }

        Thread.sleep(25)
    }
}

fun useTimedLoop() {
    val socket = KSocket()
    socket.open("/tmp/kotlin-socket2.sk")

    socket.readTimed { size, data ->
        if(size >= 1) {
            println(data)
        }
    }
}