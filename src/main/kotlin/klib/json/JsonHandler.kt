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
import net.jemzart.jsonkraken.JsonKraken

/**
 * JsonHandler
 *
 * @since 3.2.0
 * @author Thomas Obernosterer
 */
class JsonHandler : Json {
    /**
     * Convert a Object to a JSON String
     *
     * @param data The Object to convert
     * @return string The JSON String
     *
     * @since 3.2.0
     * @author Thomas Obernosterer
     */
    override fun fromObject(data: Any): String {
        return JsonKraken.serialize(data)
    }

    /**
     * Convert a JSON String to a Object
     *
     * @param data The JSON String
     * @return Any The Object
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    override fun toObject(data: String): Any? {
        return JsonKraken.deserialize(data)
    }

    override fun toArray(data: String): JsonArray? {
        val obj = toObject(data)

        if (obj is JsonArray)
            return obj

        return null
    }
}
