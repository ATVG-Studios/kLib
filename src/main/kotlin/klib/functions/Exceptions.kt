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
 * Run code with Boolean return status inside Try-Catch
 *
 * @param block
 * @return
 *
 * @since 0.1.0
 * @author Thomas Obernosterer
 */
fun exceptionHandled(block: () -> Boolean): Boolean {
    return try {
        block()
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}

/**
 * Run code with T return inside Try-Catch
 *
 * @param block Code to execute in Try-Catch
 * @return Instance of T
 *
 * @since 0.1.6
 * @author Thomas Obernosterer
 */
inline fun <T> eHandled(block: () -> T) = try { block() } catch (e: Throwable) { e.printStackTrace() }
