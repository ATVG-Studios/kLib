package klib.objects.library

import klib.types.library.LClass
import klib.types.library.LFunction
import java.io.File
import java.io.FileNotFoundException
import java.net.URL
import java.net.URLClassLoader

/**
 * Jar Library loading API
 *
 * Dynamically load Classes and Methods from Jar files
 *
 * @since 1.3.0 (Experimental)
 * @author Thomas Obernosterer
 */
@klib.annotations.Experimental
object Library {
    /**
     * Dynamically load a Class from a Jar File
     *
     * @param file The Jar file to load from
     * @param className The Class to load
     * @return Returns a LClass object
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     *
     * @see LClass
     *
     * @since 1.3.0 (Experimental)
     * @author Thomas Obernosterer
     */
    @Throws(FileNotFoundException::class, ClassNotFoundException::class)
    fun loadClassFromJar(file: File, className: String): LClass {
        if (!file.exists()) throw FileNotFoundException()
        val child = URLClassLoader(arrayOf<URL>(file.toURI().toURL()), this.javaClass.classLoader)
        val classFromJar = Class.forName(className, true, child)
        return LClass(classFromJar)
    }

    /**
     * Dynamically load a Method/Function from a Jar File
     *
     * @param file The Jar file to load from
     * @param className The Class to load from
     * @param functionName The Method to load
     * @return Returns a LFunction object
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     *
     * @see LClass
     * @see LFunction
     *
     * @since 1.3.0 (Experimental)
     * @author Thomas Obernosterer
     */
    @Throws(FileNotFoundException::class, ClassNotFoundException::class, NoSuchMethodException::class)
    fun loadFunctionFromJar(file: File, className: String, functionName: String): LFunction {
        if (!file.exists()) throw FileNotFoundException()
        val child = URLClassLoader(arrayOf<URL>(file.toURI().toURL()), this.javaClass.classLoader)
        val classFromJar = Class.forName(className, true, child)
        val method = classFromJar.methods.find { it.name == functionName } ?: throw NoSuchMethodException()
        val classConstructor = classFromJar.getConstructor()
        val classObject = classConstructor.newInstance()
        return LFunction(classObject, method)
    }
}