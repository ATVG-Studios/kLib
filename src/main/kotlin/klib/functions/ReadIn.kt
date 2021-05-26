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

import klib.extensions.asIntOr
import klib.extensions.asLongOr

/**
 * Read Int from STDIN
 *
 * @param default The default when input was null (Default: -1)
 * @return User input as Integer or default
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
fun readInt(default: Int = -1): Int {
    return readLine() asIntOr default
}

/**
 * Read Long from STDIN
 *
 * @param default The default when input was null (Default: -1)
 * @return User input as Long or default
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
fun readLong(default: Long = -1L): Long {
    return readLine() asLongOr default
}
