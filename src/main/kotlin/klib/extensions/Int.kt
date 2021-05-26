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

import java.lang.reflect.Modifier

/**
 * Checks if the given modifier is one of:
 *
 * Public, Private, Protected or Native
 *
 * @return True when any of the above modifiers matches; False otherwise
 */
fun Int.isCallableMethodModifier(): Boolean {
    return Modifier.isProtected(this) ||
        Modifier.isPrivate(this) ||
        Modifier.isPublic(this) ||
        Modifier.isNative(this)
}
