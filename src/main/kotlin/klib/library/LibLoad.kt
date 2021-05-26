/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.library

/**
 * Library Data Wrapper class for DSLs
 *
 * @param file The file to load from
 * @param className The class to load
 * @param functionName The function to load
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
class LibLoad(var file: String = "", var className: String = "", var functionName: String = "")
