/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.json

import net.jemzart.jsonkraken.JsonArray

/**
 * Common JSON Parser Interface
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
interface Json {
    /**
     * Convert Object to Json
     *
     * @since 0.1.3
     * @author Thomas Obernosterer
     */
    fun fromObject(data: Any): String

    /**
     * Convert Json to Any
     *
     * @param data The Json String
     * @return Type as Any if data is parsable; Otherwise null
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun toObject(data: String): Any?

    /**
     * Convert Json to JsonArray
     *
     * @param data The Json String
     * @return Type as Any if data is parsable; Otherwise null
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun toArray(data: String): JsonArray?
}
