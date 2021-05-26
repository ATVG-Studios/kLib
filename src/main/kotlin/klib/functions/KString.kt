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

import klib.text.KString

/**
 * StringBuilder DSL
 *
 * @param builder Receiver of KString Builder
 * @return Build String
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
fun kstring(builder: KString.() -> Unit): String {
    return KString().apply(builder).toString()
}
