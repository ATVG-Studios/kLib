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

import klib.SemVer

fun main() {
    val semver1 = SemVer.parse("1.0.0")
    println(semver1)

    val semver2 = SemVer.parse("1.0.0-beta")
    println(semver2)

    val semver3 = SemVer.parse("1.0.0-beta+4")
    println(semver3)
}
