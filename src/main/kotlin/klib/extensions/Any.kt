package klib.extensions

import klib.kLibInf
import klib.typealiases.Function_Any

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
 * Any? or Function
 *
 * @param block The function to execute when Any is null
 *
 * @since 0.1.6
 * @author Thomas Obernosterer
 */
infix fun Any?.orFun(block: Function_Any): Any? {
    if (this == null) {
        return block()
    }
    return this
}

/**
 * Any? or Any
 *
 * @param something Return Something is Any is null
 *
 * @since 0.1.6
 * @author Thomas Obernosterer
 */
infix fun Any?.or(something: Any): Any {
    if (this == null) {
        return something
    }
    return this
}

/**
 * Convert Any to Json using a JsonHandler
 *
 * @return Any as Json
 *
 * @see kLibInf.jsonHandler
 *
 * @since <NEXT_VERSION>
 * @author Nils Rider
 */
fun Any.toJson(): String {
    return kLibInf.jsonHandler.fromObject(this)
}