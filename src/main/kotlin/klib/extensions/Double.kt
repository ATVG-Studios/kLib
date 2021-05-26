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

/**
 * Calculate Double to the power of n
 *
 * @param n The exponent
 * @return Double to the power of n
 *
 * @since 1.0.0
 * @author Thomas Obernosterer
 */
infix fun Double.power(n: Int): Double {
    var tmpInt = this

    if (n == 0)
        return 1.00

    for (i in 1 until n)
        tmpInt *= this

    return tmpInt
}
