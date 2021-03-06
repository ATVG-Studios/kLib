/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.parser.influx

import klib.extensions.toSimpleString
import java.io.Serializable

/**
 * InfluxData simple data class with toString to create a Influx v2 Measurement Line (for line api)
 *
 * @since 5.2.0
 * @author Thomas Obernosterer
 */
data class InfluxData(
    val measurement: String,
    val tags: Map<String, Any>,
    val fields: Map<String, Any>,
    val timestamp: String
) :
    Serializable {
    override fun toString(): String {
        return "$measurement,${tags.toSimpleString()} ${fields.toSimpleString()} $timestamp"
    }
}
