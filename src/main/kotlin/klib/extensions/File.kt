package klib.extensions

import klib.annotations.Experimental
import klib.objects.library.Library
import klib.types.library.LClass
import klib.types.library.LFunction
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

/**
 * Load the file as library and load a class from it
 *
 * @param className The class to load
 * @return a LClass with the loaded class
 *
 * @since 1.3.0 (Experimental)
 * @author Thomas Obernosterer
 */
@UseExperimental(Experimental::class)
infix fun File.loadAsLibraryWithClass(className: String): LClass {
    return Library.loadClassFromJar(this, className)
}

/**
 * Load the file as library and load a method from it
 *
 * @param className The class to load from
 * @param functionName The method to load
 * @return a LFunction with the loaded method
 *
 * @since 1.3.0 (Experimental)
 * @author Thomas Obernosterer
 */
@UseExperimental(Experimental::class)
fun File.loadAsLibraryWithFunction(className: String, functionName: String): LFunction {
    return Library.loadFunctionFromJar(this, className, functionName)
}