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
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty
import kotlin.reflect.full.isSupertypeOf
import kotlin.reflect.full.memberProperties

/**
 * Type Check and Type Cast made easy
 *
 * @param block Code to execute when Any is T; With Any as T as argument
 *
 * @since 0.1.4
 * @author Thomas Obernosterer
 */
inline fun <reified T> Any.ofType(block: (T) -> Unit) {
    if (this is T) {
        block(this as T)
    }
}

/**
 * Any? or Any
 *
 * @param something Return Something is Any is null
 * @see orNullable for nullable
 *
 * @since 0.1.6
 * @author Thomas Obernosterer
 */
infix fun Any?.or(something: Any): Any {
    return this ?: something
}

/**
 * Convert Any to Json using a JsonHandler
 *
 * @return Any as Json
 *
 * @see kLibInf.jsonHandler
 *
 * @since 1.2.0
 * @author Nils Rider
 */
fun Any.toJson(): String {
    return kLibInf.jsonHandler.fromObject(this)
}

/**
 * Any? or Any?
 *
 * @param something Return Something is Any is null
 * @see or for non-nullable
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
infix fun Any?.orNullable(something: Any?): Any? {
    return this ?: something
}

/**
 * Utility function to copy properties from one object to another using reflections
 *
 * Only copies Properties that exist on both Object, are Mutable and Type compatible
 *
 * Source from https://stackoverflow.com/a/49043283
 *
 * @param fromObject Object to copy from
 * @param props Whitelist of Properties to copy, specify none to copy all possible
 *
 * @since 5.3.0
 * @author Strelok (https://stackoverflow.com/users/2788/strelok)
 * @author Thomas Obernosterer
 */
fun <T : Any, R : Any> T.copyFrom(fromObject: R, vararg props: KProperty<*>) {
    // get all mutable properties
    val mutableProps = this::class.memberProperties.filterIsInstance<KMutableProperty<*>>()

    // if source list is provided use that otherwise use all available properties
    val sourceProps = if (props.isEmpty()) fromObject::class.memberProperties else props.toList()

    // copy all matching properties
    mutableProps.forEach { targetProp ->
        sourceProps.find {
            // make sure properties have same name and compatible types
            it.name == targetProp.name && targetProp.returnType.isSupertypeOf(it.returnType)
        }?.let { matchingProp ->
            targetProp.setter.call(this, matchingProp.getter.call(fromObject))
        }
    }
}
