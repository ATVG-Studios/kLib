/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package devtests

import klib.net.socket.KSocket

fun main() {
    useWhileLoop()
    useTimedLoop()
}

fun useWhileLoop() {
    val socket = KSocket()
    socket.open("/tmp/kotlin-socket.sk")

    while (socket.canRead) {
        if (socket.read() >= 1) {
            println(socket.data)
        }

        Thread.sleep(25)
    }
}

fun useTimedLoop() {
    val socket = KSocket()
    socket.open("/tmp/kotlin-socket2.sk")

    socket.readTimed { size, data ->
        if (size >= 1) {
            println(data)
        }
    }
}
