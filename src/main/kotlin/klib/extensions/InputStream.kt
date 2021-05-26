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

import klib.zip.ZipFile
import java.io.File
import java.io.InputStream

/**
 * Write InputStream into File
 *
 * @param file The file to write into
 *
 * @since 1.2.0
 * @author Thomas Obernosterer
 */
fun InputStream.toFile(file: File) {
    file.outputStream().use { this.copyTo(it) }
}

/**
 * Write InputStream into a File inside a ZipFile
 *
 * @param file The file to write into
 * @param zipFile The zipFile the file gets added to
 *
 * @since 1.2.0
 * @author Thomas Obernosterer
 */
fun InputStream.toFileInZipFile(file: File, zipFile: ZipFile) {
    toFile(file)
    zipFile.addFile(file)
}

/**
 * Read a input streams content
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun InputStream.readText(): String {
    return this.bufferedReader().readText()
}
