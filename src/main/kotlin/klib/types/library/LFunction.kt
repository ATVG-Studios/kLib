package klib.types.library

import java.lang.reflect.Method

/**
 * Custom Function class to handle Dynamically loaded Methods
 *
 * @param sourceClass A class instance (object) to run in
 * @param sourceMethod A method instance (object) to run
 *
 * @since 1.3.0 (Experimental)
 * @author Thomas Obernosterer
 */
class LFunction (
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
     * @return Unknown (Defined by Dynamic Library)
     *
     * @since 1.3.0 (Experimental)
     * @author Thomas Obernosterer
     */
    operator fun invoke(): Any? {
        return sourceMethod.invoke(sourceClass)
    }
}