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

/**
 *  Transforms a Map of <K, V> into a key=value comma separated list
 *
 *  K and V must provide a toString function that only returns a simple string
 *
 * @since 5.2.0
 * @author Thomas Obernosterer
 */
fun Map<*, *>.toSimpleString(): String = this.map { "${it.key.toString().normalize()}=${it.value.toString().normalize()}" }.joinToString(",")
