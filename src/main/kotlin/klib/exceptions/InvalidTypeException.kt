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

/**
 * Custom exception
 *
 * @param cannotHandle
 * @param asType
 *
 * @since 2.0.0
 * @author Thomas Obernosterer
 */
class InvalidTypeException(cannotHandle: String, asType: String) : Exception("Cannot use $cannotHandle as $asType")
