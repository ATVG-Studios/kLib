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

import java.lang.reflect.Method

/**
 * Custom Function class to handle Dynamically loaded Methods
 *
 * @param sourceClass A class instance (object) to run in
 * @param sourceMethod A method instance (object) to run
 *
 * @since 1.3.0 (Experimental)
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
class LFunction(
    private val sourceClass: Any,
    private val sourceMethod: Method
) {
    /**
     * Run the sourceMethod
     *
     * @param params A list of arguments for the function
     * @return Unknown (Defined by Dynamic Library)
     *
     * @since 1.3.0 (Experimental)
     * @author Thomas Obernosterer
     */
    operator fun invoke(vararg params: Any?): Any? {
        return sourceMethod.invoke(sourceClass, params)
    }

    /**
     * Run the sourceMethod
     *
     * @param param A single arguments for the function
     * @return Unknown (Defined by Dynamic Library)
     *
     * @since 1.4.0 (Experimental)
     * @author Thomas Obernosterer
     */
    operator fun invoke(param: Any?): Any? {
        return sourceMethod.invoke(sourceClass, param)
    }

    /**
     * Run the sourceMethod
     *
     * @return Unknown (Defined by Dynamic Library)
     *
     * @since 1.3.0 (Experimental)
     * @author Thomas Obernosterer
     */
    operator fun invoke(): Any? {
        return sourceMethod.invoke(sourceClass)
    }
}
