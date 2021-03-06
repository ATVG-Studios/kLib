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

import klib.Konfig

fun main() {
    val testKonfig =
        """
        test=["I","need","HELP!"]
        help=false
        map={a:0,b:102}
        """.trimIndent()

    println(Konfig.parseString(testKonfig))

    if ((Konfig.parseString(testKonfig)["help"] as Boolean)) {
        println("Help was True")
    }
}
