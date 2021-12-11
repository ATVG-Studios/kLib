/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.text

interface Writer {
    fun write(text: String?) {
        println(text)
    }
    fun error(text: String?) {
        System.err.println(text)
    }
}

val ErrorOnlyWriter by lazy {
    object : Writer {
        override fun write(text: String?) {
            // Override write with empty function to only print out error states
        }
    }
}

val DefaultWriter by lazy { object : Writer {} }
