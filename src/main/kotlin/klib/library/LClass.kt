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

import klib.extensions.isCallableMethodModifier
import java.io.FileNotFoundException
import java.lang.reflect.Method

/**
 * Custom Class to handle Dynamically loaded Classes
 *
 * @since 1.3.0 (Experimental)
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
class LClass(
    private val sourceClass: Class<*>
) {
    private val methods: MutableList<Method> = ArrayList()

    init {
        var clazz: Class<*>? = sourceClass

        // Loop as long as clazz is not null (Superclassess available)
        while (clazz != null) {
            // Loop over all delared methods
            for (method in clazz.declaredMethods) {
                // Get the modifiers of the method to do checks
                val mods = method.modifiers
                // Check if the method is Public, Private, Protected or Native
                if (mods.isCallableMethodModifier()) {
                    // Add the method to our known list of methods
                    methods.add(method)
                }
            }
            // Set the super as next clazz
            clazz = clazz.superclass
        }
    }

    /**
     * Create a new Instance of the Host class
     *
     * @return Any as instance of sourceClass
     *
     * @since 2.1.0 (Experimental)
     * @author Thomas Obernosterer
     */
    fun new(): Any = sourceClass.getConstructor().newInstance()

    /**
     * Get a function from the Host class and execute it
     *
     * @param method The function to load
     * @return Unknown (Defined by Dynamic Library)
     * @throws NoSuchMethodException
     *
     * @since 1.4.0 (Experimental)
     * @author Thomas Obernosterer
     */
    @Throws(NoSuchMethodException::class)
    operator fun invoke(method: String): Any? {
        return getMethod(method).invoke()
    }

    /**
     * Get a function from the Host class and execute it
     *
     * @param method The function to load
     * @param param A single arguments for the function
     * @return Unknown (Defined by Dynamic Library)
     * @throws NoSuchMethodException
     *
     * @since 1.4.0 (Experimental)
     * @author Thomas Obernosterer
     */
    @Throws(NoSuchMethodException::class)
    operator fun invoke(method: String, param: Any?): Any? {
        return getMethod(method).invoke(param)
    }

    /**
     * Get a function from the Host class and execute it
     *
     * @param method The function to load
     * @param params A list of arguments for the function
     * @return Unknown (Defined by Dynamic Library)
     * @throws NoSuchMethodException
     *
     * @since 1.4.0 (Experimental)
     * @author Thomas Obernosterer
     */
    @Throws(NoSuchMethodException::class)
    operator fun invoke(method: String, vararg params: Any?): Any? {
        return getMethod(method).invoke(params)
    }

    /**
     * Get a function from the Host class
     *
     * @param functionName The function to load
     * @return A LFunction
     * @throws FileNotFoundException
     * @throws NoSuchMethodException
     *
     * @see LFunction
     *
     * @since 1.3.0 (Experimental)
     * @author Thomas Obernosterer
     */
    @Throws(FileNotFoundException::class, NoSuchMethodException::class)
    fun getMethod(functionName: String): LFunction {
        val method = methods.find { it.name == functionName } ?: throw NoSuchMethodException()
        val classObject = new()
        return LFunction(classObject, method)
    }

    /**
     * Get all defined Methods from Host class
     *
     * @return List of LFunction
     *
     * @see LFunction
     *
     * @since 1.4.0 (Experimental)
     * @author Thomas Obernosterer
     */
    fun getAllMethods(): List<LFunction> {
        val functions: MutableList<LFunction> = ArrayList()
        val classObject = new()
        methods.forEach {
            functions.add(LFunction(classObject, it))
        }
        return functions
    }
}
