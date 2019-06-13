package klib.extensions

import klib.kLibInf
import java.io.File
import java.lang.reflect.Type
import java.net.URL

/**
 * Download a URL to File
 *
 * @param file File to download to
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun URL.toFile(file: File) {
    this.openStream().toFile(file)
}

/**
 * Download json and parse to Type
 *
 * @param type The type to parse to
 * @see kLibInf.jsonHandler
 * @see klib.interfaces.Json
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun URL.toObjectOfType(type: Type): Any? {
    return kLibInf.jsonHandler.toObject(this.readText(), type)
}