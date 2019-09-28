package devtests

import klib.net.socket.kSock

fun main() {
    kSock.open {
        println(it.readText().trim())
    }
}