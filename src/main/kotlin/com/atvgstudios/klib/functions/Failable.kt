package com.atvgstudios.klib.functions

import com.atvgstudios.klib.typealiases.Function

/**
 * Require something to be not null; Else execute onError
 *
 * @param something The value to check on null
 * @param onError Code to execute of something is null
 *
 * @since 0.1.6
 * @author Thomas Obernosterer
 */
fun requireOrFail(something: Any?, onError: Function) {
    if (something == null)
        onError()
}

/**
 * Require something to be not null; Else execute onError
 *
 * @param somethings The values to check on null
 * @param onError Code to execute of something is null
 *
 * @since 0.1.6
 * @author Thomas Obernosterer
 */
fun requireAllOrFail(vararg somethings: Any?, onError: Function) {
    somethings.forEach {
        if (it == null)
            onError()
    }
}
