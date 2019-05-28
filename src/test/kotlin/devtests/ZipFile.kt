package devtests

import klib.annotations.Experimental
import klib.extensions.asFile
import klib.types.zip.ZipFile

@UseExperimental(Experimental::class)
fun main() {
    val zipFile = ZipFile("/stmp/Documents.zip")
    zipFile.unzip("/stmp".asFile())
}