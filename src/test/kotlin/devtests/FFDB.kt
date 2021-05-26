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

import klib.annotations.Experimental
import klib.ffdb.FFDB

@OptIn(Experimental::class)
fun main() {
    val db = FFDB.open("/stmp/testing.ffdb", FFDB.Version.V2.version)

    val user = User(1, "Thomas", "Obernosterer", "thomas.obernosterer@atvg-studios.com")

    db.write(user)
    db.flush()

    val data = db.readAll()

    data.forEach {
        if (it is User) {
            println(it.first_name)
        }
    }
}
