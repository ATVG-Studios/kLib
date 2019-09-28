package klib.extensions

import klib.hash.HashResult
import klib.hash.Sha1
import klib.hash.Sha256
import klib.library.LClass
import klib.library.LFunction
import klib.library.Library
import klib.zip.ZipFile
import java.io.File
import java.io.FileNotFoundException
import java.net.URL

/**
 * Add a file to a ZipFile
 *
 * @param zipFile The file to add to
 *
 * @since 1.2.0
 * @author Thomas Obernosterer
 */
fun File.addToZipFile(zipFile: ZipFile) = zipFile.addFile(this)

/**
 * Load the file as library and load a class from it
 *
 * @param className The class to load
 * @return a LClass with the loaded class
 * @throws FileNotFoundException
 * @throws ClassNotFoundException
 *
 * @since 1.3.0 (Experimental)
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
@Throws(FileNotFoundException::class, ClassNotFoundException::class)
infix fun File.loadAsLibraryWithClass(className: String): LClass {
    return Library.loadClassFromJar(this, className)
}

/**
 * Load the file as library and load a method from it
 *
 * @param className The class to load from
 * @param functionName The method to load
 * @return a LFunction with the loaded method
 * @throws FileNotFoundException
 * @throws ClassNotFoundException
 * @throws NoSuchMethodException
 *
 * @since 1.3.0 (Experimental)
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
@Throws(FileNotFoundException::class, ClassNotFoundException::class, NoSuchMethodException::class)
fun File.loadAsLibraryWithFunction(className: String, functionName: String): LFunction {
    return Library.loadFunctionFromJar(this, className, functionName)
}

/**
 * Hash the content of the File with SHA256
 *
 * @since 2.0.0
 * @author Thomas Obernosterer
 */
fun File.hashSha256(): HashResult {
    return Sha256.hash(this.readBytes())
}

/**
 * Hash the content of the File with SHA1
 *
 * @since 2.0.0
 * @author Thomas Obernosterer
 */
fun File.hashSha1(): HashResult {
    return Sha1.hash(this.readBytes())
}

/**
 * Hash the content of the File with SHA256 and return 4 Bytes
 *
 * @since 2.0.0
 * @author Thomas Obernosterer
 */
fun File.Sha256Checksum(): String {
    return Sha256.hash(this.readBytes()).checksum
}

/**
 * Hash the content of the File with SHA1 and return 4 Bytes
 *
 * @since 2.0.0
 * @author Thomas Obernosterer
 */
fun File.Sha1Checksum(): String {
    return Sha1.hash(this.readBytes()).checksum
}

/**
 * Reset a file (delete if exist; create if not)
 *
 * @since 3.0.0
 * @author Thomas Obernosterer
 */
fun File.reset() {
    if (this.exists()) {
        this.delete()
        this.createNewFile()
    } else {
        this.createNewFile()
    }
}

/**
 * Download a URL into a File
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun File.fromUrl(url: URL) {
    url.toFile(this)
}