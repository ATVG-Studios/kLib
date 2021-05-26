/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.exceptions

import java.lang.Exception

/**
 * Custom exception
 *
 * @param filePath
 *
 * @since 5.1.0
 * @author Thomas Obernosterer
 */
class ZipTraversalNotAllowedException(filePath: String) : Exception("ZipFile found a path that seems to try to traverse out of the Zip Package: $filePath")
