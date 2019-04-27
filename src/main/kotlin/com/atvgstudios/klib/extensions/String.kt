package com.atvgstudios.klib.extensions

import com.atvgstudios.klib.exceptions.InvalidValueException
import com.atvgstudios.klib.exceptions.RequireValueException
import com.atvgstudios.klib.objects.hash.Sha256

/**
 * Check string is valid email
 *
 * @return True or False depending on if it matches a Regex
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
 * @return The string with first latter in uppercase
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
 * @param replaceWith The character to replace the underscore with (Default is space; Underscore not allowed)
 * @return The string with first letter and every character after a underscore in uppercase
 * @throws InvalidValueException Thrown if replaceWith contains "_"; This protects against a infinite loop
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
 * @return The SHA256 Hash of the string
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
 * @param str Not allowed String
 * @throws InvalidValueException If str is inside the String
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
 * @param str Required String
 * @throws RequireValueException If str is not inside the String
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
 * @param sub String to count
 * @return Count of sub in String
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

/**
 * Is a string a number
 *
 * @return True or False depending on if it matches a Regex
 *
 * @since 0.1.4
 * @author Thomas Obernosterer
 */
fun String.isNumeric(): Boolean {
    return Regex("\\d+").matches(this)
}

/**
 * Chop a string from the end;
 *  Inspired by QString::chop(int n)
 *
 * @param n Amount to chop from the end
 * @return The string without n from the end; Or "" if n >= length
 *
 * @since 0.1.4
 * @author Thomas Obernosterer
 */
infix fun String.chop(n: Int): String {
    if (n < 0) return this
    if (n >= length) return ""
    return this.substring(0, length - n)
}