/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.functions

import klib.SemVer
import klib.kLibInf

/**
 * Check if the used kLib is the required version (Dependency Check)
 * If not, kLibInf.exit() is called
 *
 * @param version Required Version
 * @see kLibInf.exit
 *
 * @since 2.1.0
 * @author Thomas Obernosterer
 */
fun kLibRequire(version: SemVer) {
    if (kLibInf.semver != version) {
        println("This application requires kLib $version! (Version ${kLibInf.semver} not Compatible)")
        kLibInf.exit(1)
    }
}

/**
 * Check if the used kLib is at least the required version (Dependency Check)
 * If not, kLibInf.exit() is called
 *
 * @param min Minimum Version
 * @see kLibInf.exit
 *
 * @since 4.1.0
 * @author Thomas Obernosterer
 */
fun kLibRequireMin(min: SemVer) {
    if (kLibInf.semver < min) {
        println("This application requires kLib $min! (Version ${kLibInf.semver} not Compatible)")
        kLibInf.exit(1)
    }
}

/**
 * Check if the used kLib is the required version (Dependency Check)
 * If not, kLibInf.exit() is called
 *
 * @param min Minimum Version
 * @param max Maximum Version
 * @see kLibInf.exit
 *
 * @since 3.0.0
 * @author Thomas Obernosterer
 */
fun kLibRequire(min: SemVer, max: SemVer) {
    if (kLibInf.semver < min || kLibInf.semver > max) {
        println("This application requires kLib a version between $min and $max! (Version ${kLibInf.semver} not Compatible)")
        kLibInf.exit(1)
    }
}
