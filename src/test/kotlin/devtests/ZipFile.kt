package devtests

import klib.extensions.asFile
import klib.types.zip.ZipFile

fun main() {
    val zipFile = ZipFile("/stmp/Documents.zip")
    zipFile.unzip("/stmp".asFile())
}