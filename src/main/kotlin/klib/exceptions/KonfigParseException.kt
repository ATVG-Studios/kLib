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
 * @param reason
 *
 * @since 1.1.0
 * @author Thomas Obernosterer
 */
class KonfigParseException(reason: String) : Exception("KonfigParseException: Cannot parse konf; Reason: $reason")
