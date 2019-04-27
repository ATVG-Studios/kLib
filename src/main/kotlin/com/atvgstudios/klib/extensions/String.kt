package com.atvgstudios.klib.extensions

import com.atvgstudios.klib.exceptions.InvalidValueException
import com.atvgstudios.klib.exceptions.RequireValueException
import com.atvgstudios.klib.objects.hash.Sha256

/**
 * Check string is valid email
 *
 * @return
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
fun String.isEmail(): Boolean {
    return Regex("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matches(this)
}

/**
 * Make first letter uppercase
 *
 * @return
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
fun String.toFirstLetterUpperCase(): String {
    return this.replaceFirst(this.substring(0, 1), this.substring(0, 1).toUpperCase())
}

/**
 * Make the first and every latter after a Underscore to UpperCase
 *
 * @return
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
fun String.toUpperCaseOnUnderscore(replaceWith: String = " "): String {
    replaceWith deny "_"
    var bigAfterUnderscore = this.toFirstLetterUpperCase()

    while (bigAfterUnderscore.contains("_")) {
        bigAfterUnderscore = bigAfterUnderscore.replaceAfter("_", bigAfterUnderscore.substringAfter("_").toFirstLetterUpperCase()).replaceFirst("_", replaceWith)
    }

    return bigAfterUnderscore
}

/**
 * Get SHA256 value of string
 *
 * @return
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
fun String.asSha256(): String {
    return Sha256.hash(this).hex
}

/**
 * Throw a InvalidValueException if a string contains a string
 *
 * @param str
 * @return
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
infix fun String.deny(str: String) {
    if (this.contains(str)) {
        throw InvalidValueException(str, this)
    }
}

/**
 * Throw a RequireValueException if a string does not contains a string
 *
 * @param str
 * @return
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
infix fun String.require(str: String) {
    if (!this.contains(str)) {
        throw RequireValueException(str, this)
    }
}

/**
 * Count the occurrence of a substring
 *
 * @param sub
 * @return
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
infix fun String.count(sub: String): Int {
    var count = 0
    var last = 0
    while (last != -1) {
        last = this.indexOf(sub, last)
        if (last != -1) {
            count++
            last += sub.length
        }
    }
    return count
}