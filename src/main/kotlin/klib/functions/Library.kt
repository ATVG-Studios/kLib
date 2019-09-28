package klib.functions

import klib.library.LClass
import klib.library.LFunction
import klib.library.LibLoad
import klib.library.Library
import java.io.FileNotFoundException

/**
 * Dynamically load a Class from a Jar File
 *
 * @param builder LibLoader Builder
 * @return Returns a LClass object
 * @throws FileNotFoundException
 * @throws ClassNotFoundException
 *
 * @see LClass
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
@Throws(FileNotFoundException::class, ClassNotFoundException::class)
fun loadClass(builder: LibLoad.() -> Unit): LClass {
    return Library.loadClassFromJar(LibLoad().apply(builder))
}

/**
 * Dynamically load a Method/Function from a Jar File
 *
 * @param builder LibLoader Builder
 * @return Returns a LFunction object
 * @throws FileNotFoundException
 * @throws ClassNotFoundException
 * @throws NoSuchMethodException
 *
 * @see LClass
 * @see LFunction
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
@Throws(FileNotFoundException::class, ClassNotFoundException::class, NoSuchMethodException::class)
fun loadFunction(builder: LibLoad.() -> Unit): LFunction {
    return Library.loadFunctionFromJar(LibLoad().apply(builder))
}