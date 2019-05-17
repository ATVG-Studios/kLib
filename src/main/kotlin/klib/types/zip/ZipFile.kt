package klib.types.zip

import klib.extensions.asFile
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.Exception
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

/**
 * Custom ZipFile implementation
 *
 * @param fileName The name of the new ZipFile
 * @param safeMode Handle or Expose thrown errors (Default True/Enabled)
 *
 * @since <NEXT_VERSION> (Experimental)
 * @author Thomas Obernosterer
 */
@klib.annotations.Experimental
class ZipFile(private val fileName: String, private val safeMode: Boolean = true) {
    private lateinit var zipFile: ZipOutputStream

    /**
     * Open the ZipFile
     *
     * @since <NEXT_VERSION>
     * @author Thomas Obernosterer
     */
    fun open() {
        val file = File(fileName)
        if (file.exists()) {
            throw FileAlreadyExistsException(file)
        }

        val fileWriter = FileOutputStream(file)
        zipFile = ZipOutputStream(fileWriter)
    }

    /**
     * Add File respecting the safeMode option
     *
     * @param newFile The file to add
     * @param zipPath The path inside the zip file for the new file
     * @throws Exception (Without SafeMode)
     *
     * @since <NEXT_VERSION>
     * @author Thomas Obernosterer
     */
    fun addFile(newFile: File, zipPath: String = "") {
        if (safeMode) {
            try {
                open()
                addFileUnsafe(newFile, zipPath)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                close()
            }
        } else {
            addFileUnsafe(newFile, zipPath)
        }
    }

    /**
     * Add Directory respecting the safeMode option
     *
     * @param newFolder The folder to add
     * @param zipPath The path inside the zip file for the new folder
     * @throws Exception (Without SafeMode)
     *
     * @since <NEXT_VERSION>
     * @author Thomas Obernosterer
     */
    fun addDirectory(newFolder: File, zipPath: String = "") {
        if (safeMode) {
            try {
                open()
                addDirectoryUnsafe(newFolder, zipPath)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                close()
            }
        } else {
            addDirectoryUnsafe(newFolder, zipPath)
        }
    }

    /**
     * Close the ZipFile
     *
     * @since <NEXT_VERSION>
     * @author Thomas Obernosterer
     */
    fun close() {
        zipFile.flush()
        zipFile.close()
    }

    /**
     * Add File without protection of errors
     *
     * @param newFile The file to add
     * @param zipPath The path inside the zip file for the new file
     * @throws Exception
     *
     * @since <NEXT_VERSION>
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
     *
     * @since <NEXT_VERSION>
     * @author Thomas Obernosterer
     */
    private fun addDirectoryUnsafe(newFolder: File, zipPath: String = "") {
        for (fileName in newFolder.list()) {
            val newPath = if (zipPath != "") "$zipPath/${newFolder.name}" else newFolder.name
            addFileUnsafe("${newFolder.absolutePath}/$fileName".asFile(), newPath)
        }
    }

    /**
     * Create a new Buffer
     *
     * @return ByteArray of size 1024
     *
     * @since <NEXT_VERSION>
     * @author Thomas Obernosterer
     */
    private fun getBuffer() = ByteArray(1024)
}