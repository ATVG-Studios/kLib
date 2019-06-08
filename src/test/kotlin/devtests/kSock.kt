package devtests

import klib.objects.kSock

fun main() {
    kSock.open {
        println(it.readText().trim())
    }
}