package klib.extensions

import java.io.File
import java.io.InputStream

/**
 * Write InputStream into File
 *
 * @param file The file to write into
 *
 * @since <NEXT_VERSION>
 * @author Thomas Obernosterer
 */
fun InputStream.toFile(file: File) {
    file.outputStream().use { this.copyTo(it) }
}