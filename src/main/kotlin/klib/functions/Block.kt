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

import klib.text.ErrorOnlyWriter
import klib.text.Writer

inline fun namedBlock(name: String, writer: Writer = ErrorOnlyWriter, block: () -> Unit) {
    writer.write("[BLOCK '$name'] Running code-block")
    try {
        block()
    } catch (e: Exception) {
        writer.error("[BLOCK '$name'] Failed to run!")
        writer.error("[BLOCK '$name'] Shows error: '${e.message}'")
        writer.error("Stacktrace:")
        writer.error(e.stackTraceToString())
    }
}
