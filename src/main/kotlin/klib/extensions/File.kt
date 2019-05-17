package klib.extensions

import klib.annotations.Experimental
import klib.types.zip.ZipFile
import java.io.File

/**
 * Add a file to a ZipFile
 *
 * @param zipFile The file to add to
 *
 * @since 1.2.0
 * @author Thomas Obernosterer
 */
@UseExperimental(Experimental::class)
fun File.addToZipFile(zipFile: ZipFile) = zipFile.addFile(this)