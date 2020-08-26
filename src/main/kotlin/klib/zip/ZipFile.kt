package klib.zip

import klib.exceptions.OpenNonVirtualFileFailedException
import klib.exceptions.ZipTraversalNotAllowedException
import klib.extensions.asFile
import klib.extensions.count
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream

/**
 * Custom ZipFile implementation
 *
 * @param fileName The name of the new ZipFile
 * @param safeMode Handle or Expose thrown errors (Default True/Enabled)
 * @param isVirtual Boolean to decide if the ZipFill will write to a stream (virtual) or file (non-virtual)
 *
 * @since 1.2.0 (Experimental)
 * @since 2.1.0
 * @since 5.1.0 - fileName parameter is nullable to support virtual files
 * @author Thomas Obernosterer
 */
class ZipFile(private val fileName: String?, private val safeMode: Boolean = true, private val isVirtual: Boolean = false) {
    private lateinit var zipFile: ZipOutputStream
    private var fileOpen = false

    /**
     * Open the non-virtual ZipFile
     *
     * This opens the given File and attaches the zip stream to its output stream
     *
     * @throws OpenNonVirtualFileFailedException
     *
     * @since 1.2.0
     * @since 5.1.0 - Throws a Exception if fileName is null but virtualFile is false
     * @author Thomas Obernosterer
     */
    fun open(openIfExist: Boolean = false) {
        if (fileOpen) return

        // If there is no name given
        if (fileName == null) {
            // and the file is not virtual
            if (!isVirtual) {
                // file with an error
                throw OpenNonVirtualFileFailedException()
            } else {
                // open the virtual file and return
                return openVirtual(null)
            }
        }

        val file = File(fileName)
        if (!openIfExist && file.exists()) {
            throw FileAlreadyExistsException(file)
        }

        val fileWriter = FileOutputStream(file)
        zipFile = ZipOutputStream(fileWriter)
        fileOpen = true
    }

    /**
     * Open the virtual ZipFile
     *
     * This function attaches the Zip stream to the output stream, allowing for the ZipFile to be send
     * via a Socket or manually be written to a file.
     *
     * @since 5.1.0
     * @author Thomas Obernosterer
     */
    fun openVirtual(outputStream: OutputStream?) {
        if (fileOpen) return

        zipFile = ZipOutputStream(outputStream)
        fileOpen = true
    }

    /**
     * Add File respecting the safeMode option
     *
     * @param newFile The file to add
     * @param zipPath The path inside the zip file for the new file
     * @throws Exception (Without SafeMode)
     * @throws ZipTraversalNotAllowedException
     *
     * @since 1.2.0
     * @author Thomas Obernosterer
     */
    fun addFile(newFile: File, zipPath: String = "") {
        if (safeMode) {
            try {
                open()
                addFileUnsafe(newFile, zipPath)
            } catch (e: Exception) {
                e.printStackTrace()
                close()
            }
        } else {
            addFileUnsafe(newFile, zipPath)
        }
    }

    /**
     * Add Files respecting the safeMode option
     *
     * @param newFiles The files to add
     * @param zipPath The path inside the zip file for the new files
     * @throws Exception (Without SafeMode)
     * @throws ZipTraversalNotAllowedException
     *
     * @since 1.2.0
     * @author Thomas Obernosterer
     */
    fun addFiles(vararg newFiles: File, zipPath: String = "") {
        if (safeMode) {
            try {
                open()
                addFilesUnsafe(*newFiles, zipPath = zipPath)
            } catch (e: Exception) {
                e.printStackTrace()
                close()
            }
        } else {
            addFilesUnsafe(*newFiles, zipPath = zipPath)
        }
    }

    /**
     * Add Directory respecting the safeMode option
     *
     * @param newFolder The folder to add
     * @param zipPath The path inside the zip file for the new folder
     * @throws Exception (Without SafeMode)
     * @throws ZipTraversalNotAllowedException
     *
     * @since 1.2.0
     * @author Thomas Obernosterer
     */
    fun addDirectory(newFolder: File, zipPath: String = "") {
        if (safeMode) {
            try {
                open()
                addDirectoryUnsafe(newFolder, zipPath)
            } catch (e: Exception) {
                e.printStackTrace()
                close()
            }
        } else {
            addDirectoryUnsafe(newFolder, zipPath)
        }
    }

    /**
     * Close the ZipFile
     *
     * @since 1.2.0
     * @author Thomas Obernosterer
     */
    fun close() {
        zipFile.flush()
        zipFile.close()
        fileOpen = false
    }

    /**
     * Extract a ZipFile
     *
     * @param targetPath The path to extract into
     * @see unzip
     *
     * @since 2.1.0
     * @author Thomas Obernosterer
     */
    fun extract(targetPath: File) = unzip(targetPath)

    /**
     * Extract a ZipFile
     *
     * @param targetPath The path to extract into
     * @throws ZipTraversalNotAllowedException
     *
     * @since 2.1.0
     * @since 5.1.0 - Throws exception if filename inside Zip contains a traversal
     * @author Thomas Obernosterer
     */
    fun unzip(targetPath: File) {
        if (fileName == null) {
            throw java.lang.Exception("ZipFile: Missing fileName to unzip!")
        }

        val zFile = File(fileName)
        if (!zFile.exists()) throw FileNotFoundException()

        val zipInputStream = ZipInputStream(BufferedInputStream(FileInputStream(zFile)))

        zipInputStream.use { zipStream ->
            val buffer = getBuffer(8192)

            while (true) {
                val zipEntry = zipStream.nextEntry ?: break

                checkPathForTraversalAttack(zipEntry.name)

                val file = File(targetPath, zipEntry.name)
                val dir = if (zipEntry.isDirectory) file else file.parentFile
                if (!dir.isDirectory && !dir.mkdirs()) throw FileNotFoundException("Failed to ensure directory: " + dir.canonicalPath)

                if (zipEntry.isDirectory) continue

                val fileOutputStream = FileOutputStream(file)
                fileOutputStream.use {
                    while (true) {
                        val count = zipStream.read(buffer)
                        if (count <= 0) break
                        it.write(buffer, 0, count)
                    }
                }
                val time = zipEntry.time
                if (time > 0) {
                    file.setLastModified(time)
                }
            }
        }
    }

    /**
     * Add File without protection of errors
     *
     * @param newFiles The files to add
     * @param zipPath The path inside the zip file for the new files
     * @throws Exception
     * @throws ZipTraversalNotAllowedException
     *
     * @since 1.2.0
     * @author Thomas Obernosterer
     */
    private fun addFilesUnsafe(vararg newFiles: File, zipPath: String = "") {
        for (file in newFiles) {
            addFileUnsafe(file, zipPath)
        }
    }

    /**
     * Add File without protection of errors
     *
     * @param newFile The file to add
     * @param zipPath The path inside the zip file for the new file
     * @throws Exception
     * @throws ZipTraversalNotAllowedException
     *
     * @since 1.2.0
     * @since 5.1.0 - Has traversal attack protection
     * @author Thomas Obernosterer
     */
    private fun addFileUnsafe(newFile: File, zipPath: String = "") {
        if (newFile.isDirectory) {
            addDirectory(newFile, zipPath)
            return
        }

        val buffer = getBuffer()
        val fileInputStream = FileInputStream(newFile)
        val newPath = if (zipPath != "") "$zipPath/" else ""

        checkPathForTraversalAttack(newPath)

        zipFile.putNextEntry(ZipEntry("$newPath${newFile.name}"))

        while (true) {
            val len = fileInputStream.read(buffer)
            if (len <= 0) {
                break
            }
            zipFile.write(buffer, 0, len)
        }
    }

    /**
     * Add Directory without protection of errors
     *
     * @param newFolder The folder to add
     * @param zipPath The path inside the zip file for the new folder
     * @throws Exception
     * @throws ZipTraversalNotAllowedException
     *
     * @since 1.2.0
     * @since 5.1.0 - Has traversal attack protection
     * @author Thomas Obernosterer
     */
    private fun addDirectoryUnsafe(newFolder: File, zipPath: String = "") {
        newFolder.list()?.forEach { fileName ->
            val newPath = if (zipPath != "") "$zipPath/${newFolder.name}" else newFolder.name

            checkPathForTraversalAttack(newPath)

            addFileUnsafe("${newFolder.absolutePath}/$fileName".asFile(), newPath)
        }
    }

    /**
     * Create a new Buffer
     *
     * @return ByteArray of size 1024
     *
     * @since 1.2.0
     * @author Thomas Obernosterer
     */
    private fun getBuffer(size: Int = 1024) = ByteArray(size)

    /**
     * Checks if a path looks like it would try to prepare for a traversal attack
     *
     * @param newPath Path to check
     */
    private fun checkPathForTraversalAttack(newPath: String) {
        // When the file starts with a ../ we wont accept it, even if the Path resolves to a valid location
        if (newPath.startsWith("../")) {
            throw ZipTraversalNotAllowedException(newPath)
        }

        val slashCount = newPath.count { it == '/' }
        val dotsCount = newPath.count("..")

        /**
         * When we count equal or more .. then we count /, it could be possible that a zip traversal attack package
         * is currently be build. As those can be bad, wont allow this. Even if the Path resolves to a valid location
         * inside the package.
         */
        if (dotsCount >= slashCount) {
            throw ZipTraversalNotAllowedException(newPath)
        }
    }
}
