package devtests

import klib.extensions.asDirectory
import klib.extensions.replaceAllOf

fun main() {
    val directory = "/stmp/vulture".asDirectory()
    val cppFiles = directory.findWithExtension("cpp").toMutableList()
    cppFiles.replaceAllOf("Vulture", "Cookie", true)
    directory.addFiles(cppFiles)
    directory.writeAll()
}