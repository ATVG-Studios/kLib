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

import klib.kLibInf
import java.io.File
import java.net.URL

/**
 * Download a URL to File
 *
 * @param file File to download to
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun URL.toFile(file: File) {
    this.openStream().toFile(file)
}

/**
 * Download json and parse to Type T
 *
 * @see kLibInf.jsonHandler
 * @see klib.json.Json
 *
 * @since 3.1.0
 * @since 4.0.0 (Generic)
 * @author Thomas Obernosterer
 */
inline fun <reified T> URL.toObjectOfType(): T? {
    val obj = kLibInf.jsonHandler.toObject(this.readText())
    if (obj is T)
        return obj

    return null
}
