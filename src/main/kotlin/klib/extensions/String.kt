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

import klib.annotations.Experimental
import klib.encoding.base.Base58e
import klib.exceptions.InvalidValueException
import klib.exceptions.RequireValueException
import klib.ffdb.FFDB
import klib.functions.alphanumericalRegex
import klib.hash.Sha1
import klib.hash.Sha256
import klib.kLibInf
import klib.library.LClass
import klib.library.LFunction
import klib.library.Library
import klib.text.KString
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.math.BigInteger
import java.util.Base64
import java.util.Locale

/**
 * Check string is valid email
 *
 * @return True or False depending on if it matches a Regex
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
fun String.isEmail(): Boolean {
    return Regex("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
        .matches(this)
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
    return this.replaceFirst(this.substring(0, 1), this.substring(0, 1).uppercase(Locale.getDefault()))
}

/**
 * Make the first and every latter after a Underscore to UpperCase
 *
 * @param replaceWith The character to replace the underscore with (Default is space; Underscore not allowed)
 * @return The string with first letter and every character after a underscore in uppercase
 *
 * @since 0.1.3
 * @since 5.1.0 - Rewritten to fix Bugs; '_' is now a valid replaceWith argument
 * @author Thomas Obernosterer
 */
fun String.toUpperCaseOnUnderscore(replaceWith: String = " "): String {
    var finalString = ""
    var skip = false

    // Loop over every character in the String
    for (i in this.indices) {
        if (skip) {
            skip = false
            continue
        }

        val char = this[i]

        // Check if the Char is a _
        val str = if (char == '_') {
            // Get the letter after _ and make it uppercase
            val letter = this[i + 1].uppercaseChar()
            skip = true
            // Apply _ replacement and add uppercase letter
            "$replaceWith$letter"
        } else {
            // Otherwise if its the fist char in the String
            if (i == 0) {
                // Make it uppercase too
                char.uppercaseChar().toString()
            } else {
                // Just add the char to the string
                char.toString()
            }
        }

        // Add the char or string to the final string
        finalString += str
    }
    return finalString
}

/**
 * Make a string to snake_case
 *
 * @return Snake cased String
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
fun String.toSnakeCase(): String {
    val newString = KString()
    var ignoreUpper = false

    for (i in this.indices) {
        when {
            this[i].isUpperCase() && i != 0 && !ignoreUpper -> {
                newString += "_${this[i].lowercaseChar()}"
            }
            this[i] == ' ' -> {
                newString += '_'
                ignoreUpper = true
            }
            else -> {
                newString += this[i].lowercaseChar()
                ignoreUpper = false
            }
        }
    }
    return newString.toString()
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
 * Get SHA1 value of string
 *
 * @return The SHA1 Hash of the string
 *
 * @since 2.0.0
 * @author Thomas Obernosterer
 */
fun String.asSha1(): String {
    return Sha1.hash(this).hex
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
    if (str.isEmpty() && this.isEmpty()) {
        throw InvalidValueException(str, this)
    }
    if (str.isEmpty() || this.isEmpty()) {
        return
    }
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
    if (str.isEmpty() && this.isEmpty()) {
        throw InvalidValueException(str, this)
    }

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
    return Regex("^\\d+$").matches(this)
}

/**
 * Chop a string from the end
 *
 * @param n Amount to chop from the end
 * @return The string without n from the end; Or "" if n >= length
 *
 * @source This feature was inspired by QString::chop() from Qt 5.12.3
 *
 * @since 0.1.4
 * @author Thomas Obernosterer
 */
infix fun String.chop(n: Int): String {
    if (n < 0) return this
    if (n >= length) return ""
    return this.substring(0, length - n)
}

/**
 * Convert a string into Base58
 *
 * @return The string as Base58
 *
 * @since 0.1.5
 * @author Thomas Obernosterer
 */
fun String.asBase58(): String {
    return Base58e.encode(this)
}

/**
 * Convert Base58 into a string
 *
 * @return The Base58 as string
 *
 * @since 0.1.5
 * @author Thomas Obernosterer
 */
fun String.fromBase58(): String {
    return String(Base58e.decode(this))
}

/**
 * Convert a string into Base64
 *
 * @return The string as Base64
 *
 * @since 0.1.5
 * @author Thomas Obernosterer
 */
fun String.asBase64(): String {
    return Base64.getEncoder().encodeToString(this.toByteArray())
}

/**
 * Convert Base64 into a string
 *
 * @return The Base64 as string
 *
 * @since 0.1.5
 * @author Thomas Obernosterer
 */
fun String.fromBase64(): String {
    return String(Base64.getDecoder().decode(this.toByteArray()))
}

/**
 * Uses the string as filename for a new File object
 *
 * @return File object with string as name
 *
 * @since 1.2.0
 * @author Thomas Obernosterer
 */
fun String.asFile() = File(this)

/**
 * Opens the string as file and returns the input stream
 *
 * @return FileInputStream with string as file
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
fun String.asFileInputStream(): FileInputStream {
    return asFile().inputStream()
}

/**
 * Opens the string as file and returns the output stream
 *
 * @return FileOutputStream with string as file
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
fun String.asFileOutputStream(): FileOutputStream {
    return asFile().outputStream()
}

/**
 * Make the string a file and load it as library and load a class from it
 *
 * @param className The class to load
 * @return a LClass with the loaded class
 * @throws FileNotFoundException
 * @throws ClassNotFoundException
 *
 * @see LClass
 *
 * @since 1.3.0 (Experimental)
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
@Throws(FileNotFoundException::class, ClassNotFoundException::class)
infix fun String.loadAsLibraryWithClass(className: String): LClass {
    return Library.loadClassFromJar(this.asFile(), className)
}

/**
 * Make the string a file and load it as library and load a method from it
 *
 * @param className The class to load from
 * @param functionName The method to load
 * @return a LFunction with the loaded method
 * @throws FileNotFoundException
 * @throws ClassNotFoundException
 * @throws NoSuchMethodException
 *
 * @see LFunction
 *
 * @since 1.3.0 (Experimental)
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
@Throws(FileNotFoundException::class, ClassNotFoundException::class, NoSuchMethodException::class)
fun String.loadAsLibraryWithFunction(className: String, functionName: String): LFunction {
    return Library.loadFunctionFromJar(this.asFile(), className, functionName)
}

/**
 * Parse to Type T
 *
 * @see klib.json.Json
 *
 * @since 3.1.0
 * @since 4.0.0 (Generic)
 * @author Thomas Obernosterer
 */
inline fun <reified T> String.toObjectOfType(): T? {
    val obj = kLibInf.jsonHandler.toObject(this)

    if (obj is T)
        return obj

    return null
}

/**
 * Convert Hex String to Int
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun String.fromHex(): Int {
    return this.toIntOrNull(16) ?: 0
}

/**
 * Convert Hex String to Long
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun String.fromHextoLong(): Long {
    return this.toLongOrNull(16) ?: 0L
}

/**
 * Replace the last x in String
 *
 * @param oldValue Old Value to be replaced
 * @param newValue New Value to replace with
 *
 * @since 4.1.0
 * @author Thomas Obernosterer
 */
fun String.replaceLast(oldValue: String, newValue: String, ignoreCase: Boolean = false): String {
    val index = this.lastIndexOf(string = oldValue, ignoreCase = ignoreCase)
    return if (index < 0 || index > this.lastIndex) this else this.replaceRange(index, index + oldValue.length, newValue)
}

/**
 * Infix wrapper for toIntOrNull
 *
 * @param or Fault Case
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
infix fun String?.asIntOr(or: Int): Int {
    return this.orEmpty().toIntOrNull() ?: or
}

/**
 * Infix wrapper for asLongOr
 *
 * @param or Fault Case
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
infix fun String?.asLongOr(or: Long): Long {
    return this.orEmpty().toLongOrNull() ?: or
}

/**
 * Infix wrapper for asLongOr with Int replacement
 *
 * @param or Fault Case
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
infix fun String?.asLongOr(or: Int): Long {
    return this.orEmpty().toLongOrNull() ?: or.toLong()
}

/**
 * Open a String as a FFDB File
 *
 * @param version FFDB File Version (Default is V2)
 *
 * @since 5.0.0
 * @author Thomas Obernosterer
 */
@OptIn(Experimental::class)
fun String.openFFDB(version: FFDB.Version = FFDB.Version.V2) = FFDB.open(this, version.version)

/**
 * Split string every num characters
 *
 * @param num The number of chars to split after
 *
 * @since 5.0.0
 * @author Thomas Obernosterer
 */
fun String.splitBy(num: Int = 1): List<String> {
    val list: MutableList<String> = ArrayList()

    for (i in num until length step num)
        list.add(substring(i - num, i))

    return list
}

/**
 * Trim ALL the Spaces
 *
 * @since 5.0.0
 * @author Thomas Obernosterer
 */
fun String.trimSpace(): String {
    return this.replace(" ", "")
}

/**
 * Check a String if it is Luhn valid
 *
 * @since 5.1.0
 * @author Thomas Obernosterer
 */
fun String.luhn10(): Boolean {
    var sum = 0
    var alternate = false
    for (i in length - 1 downTo 0) {
        var n = substring(i, i + 1).toInt()
        if (alternate) {
            n *= 2
            if (n > 9) {
                n = n % 10 + 1
            }
        }
        sum += n
        alternate = !alternate
    }
    return sum % 10 == 0
}

/**
 * Check if a String is Mod97 Valid
 *
 * @since 5.1.0
 * @author Thomas Obernosterer
 */
fun String.mod97(): Boolean {
    fun transform(src: CharSequence, srcPos: Int, srcLen: Int, dest: CharArray, destPos: Int): Int {
        var offset = destPos
        for (i in srcPos until srcLen) {
            when (val c = src[i]) {
                in '0'..'9' -> {
                    dest[offset++] = c
                }
                in 'A'..'Z' -> {
                    val tmp = 10 + (c - 'A')
                    dest[offset++] = ('0'.code + tmp / 10).toChar()
                    dest[offset++] = ('0'.code + tmp % 10).toChar()
                }
                in 'a'..'z' -> {
                    val tmp = 10 + (c - 'a')
                    dest[offset++] = ('0'.code + tmp / 10).toChar()
                    dest[offset++] = ('0'.code + tmp % 10).toChar()
                }
                else -> require(c == ' ') { "Invalid character '$c'." }
            }
        }
        return offset
    }

    val buffer = CharArray(length * 2)
    var offset: Int = transform(this, 4, length, buffer, 0)
    offset = transform(this, 0, 4, buffer, offset)
    val sum = BigInteger(String(buffer, 0, offset))
    val remainder = sum.remainder(BigInteger("97"))
    return remainder.toInt() == 1
}

/**
 *  Replaces the left side of the Map with the right side
 *
 *  @param replacers Map with replaces
 *  @return String with everything replaced as specified by the replaces Map
 *
 * @since 5.2.0
 * @author Thomas Obernosterer
 */
fun String.replaceAllOf(replacers: Map<String, String> = mapOf(" " to "_")): String {
    var cleaned = this
    replacers.forEach { (k, v) ->
        cleaned = cleaned.replace(k, v)
    }
    return cleaned
}

/**
 *  Normalizes a String into Alphanumerical
 *
 * @since 5.2.0
 * @author Thomas Obernosterer
 */
fun String.normalize(): String {
    return alphanumericalRegex().replace(this, "")
}

/**
 * Repeat the string x times
 *
 * @param times Times to repeat this
 * @return String x times
 *
 * @since 5.3.0
 * @author Thomas Obernosterer
 */
infix fun String.times(times: Int): String {
    var newString = ""
    for (i in 0 until times) {
        newString += this
    }
    return newString
}

/**
 * Checks if two Strings are Anagrams of each other
 *
 * @param other String to compare this to
 * @return True if 'this' and 'other' are anagrams
 *
 * @since 6.0.0
 * @author Thomas Obernosterer
 */
infix fun String.anagrams(other: String): Boolean {
    return this.toCharArray().sorted() == other.toCharArray().sorted()
}

/**
 * Checks if two Strings are Anagrams of each other
 *
 * @param other String to compare this to
 * @return True if 'this' and 'other' are anagrams
 * @see String.anagrams Implementation
 *
 * @since 6.0.0
 * @author Thomas Obernosterer
 */
fun String.isAnagramOf(other: String): Boolean {
    return this anagrams other
}
