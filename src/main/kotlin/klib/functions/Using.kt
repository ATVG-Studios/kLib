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

import java.io.Closeable

/**
 *  .Net like function that proxies Kotlin's .use
 *
 *  @param receiver The Closable input
 *  @param block The function that uses receiver
 *  @return Some data from block
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
inline fun <T : Closeable?, R> using(receiver: T, block: (T) -> R): R {
    return receiver.use(block)
}
