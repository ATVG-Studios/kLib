/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

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
