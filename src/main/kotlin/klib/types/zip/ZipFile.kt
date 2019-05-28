package klib.types.zip

import klib.extensions.asFile
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.lang.Exception
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream

/**
 * Custom ZipFile implementation
 *
 * @param fileName The name of the new ZipFile
 * @param safeMode Handle or Expose thrown errors (Default True/Enabled)
 *
 * @since 1.2.0 (Experimental)
 * @since 2.1.0
 * @author Thomas Obernosterer
 */
@klib.annotations.Experimental
class ZipFile(private val fileName: String, private val safeMode: Boolean = true) {
    private lateinit var zipFile: ZipOutputStream
    private var fileOpen = false

    /**
     * Open the ZipFile
     *
     * @since 1.2.0
     * @author Thomas Obernosterer
     */
    fun open() {
        if (fileOpen) return

        val file = File(fileName)
        if (file.exists()) {
            throw FileAlreadyExistsException(file)
        }

        val fileWriter = FileOutputStream(file)
        zipFile = ZipOutputStream(fileWriter)
        fileOpen = true
    }

    /**
     * Add File respecting the safeMode option
     *
     * @param newFile The file to add
     * @param zipPath The path inside the zip file for the new file
     * @throws Exception (Without SafeMode)
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
     *
     * @since 2.1.0
     * @author Thomas Obernosterer
     */
    fun unzip(targetPath: File) {
        val zFile = File(fileName)
        if(!zFile.exists()) throw FileNotFoundException()

        val zipInputStream = ZipInputStream(BufferedInputStream(FileInputStream(zFile)))

        zipInputStream.use {  zipStream ->
            val buffer = getBuffer(8192)

            while (true) {
                val zipEntry = zipStream.nextEntry ?: break
                val file = File(targetPath, zipEntry.name)
                val dir = if(zipEntry.isDirectory) file else file.parentFile
                if(!dir.isDirectory && !dir.mkdirs()) throw FileNotFoundException("Failed to ensure directory: " + dir.canonicalPath)

                if(zipEntry.isDirectory) continue

                val fileOutputStream = FileOutputStream(file)
                fileOutputStream.use {
                    while (true) {
                        val count = zipStream.read(buffer)
                        if(count <= 0) break
                        it.write(buffer, 0, count)
                    }
                }
                val time = zipEntry.time
                if(time > 0) {
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
     *
     * @since 1.2.0
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
     * @since 1.2.0
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
     * @since 1.2.0
     * @author Thomas Obernosterer
     */
    private fun getBuffer(size: Int = 1024) = ByteArray(size)
}