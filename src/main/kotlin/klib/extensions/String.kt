package klib.extensions

import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.util.Base64
import klib.encoding.base.Base58e
import klib.exceptions.InvalidValueException
import klib.exceptions.RequireValueException
import klib.hash.Sha1
import klib.hash.Sha256
import klib.kLibInf
import klib.library.LClass
import klib.library.LFunction
import klib.library.Library
import klib.text.KString

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
                newString += "_${this[i].toLowerCase()}"
            }
            this[i] == ' ' -> {
                newString += '_'
                ignoreUpper = true
            }
            else -> {
                newString += this[i].toLowerCase()
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
    return Regex("\\d+").matches(this)
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
