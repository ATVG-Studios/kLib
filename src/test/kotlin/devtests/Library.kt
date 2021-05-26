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

import klib.functions.loadClass

/**
 * Source of hello.kt

package hello

class Hello {
 fun hi() {
 println("Hello from Hello class")
 }
}

 * Compile using:
 * kotlinc -d hello.jar hello.kt
 */

fun main() {
    val hello = loadClass {
        file = "/tmp/hello.jar"
        className = "hello.Hello"
    }

    hello("hi")
}
