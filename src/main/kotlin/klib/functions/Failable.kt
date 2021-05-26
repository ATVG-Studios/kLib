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

/**
 * Require something to be not null; Else execute onError
 *
 * @param something The value to check on null
 * @param onError Code to execute of something is null
 *
 * @since 0.1.6
 * @author Thomas Obernosterer
 */
fun requireOrFail(something: Any?, onError: () -> Unit) {
    if (something == null)
        onError()
}

/**
 * Require something to be not null; Else execute onError
 *
 * @param somethings The values to check on null
 * @param onError Code to execute of something is null
 *
 * @since 0.1.6
 * @author Thomas Obernosterer
 */
fun requireAllOrFail(vararg somethings: Any?, onError: () -> Unit) {
    somethings.forEach {
        if (it == null)
            onError()
    }
}
