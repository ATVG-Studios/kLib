package klib.files

import java.io.File
import klib.annotations.Experimental
import klib.extensions.asFile

/**
 * Enhanced Directory API (v2)
 *
 * This is a rewrite of the Directory API introduced in 4.0.0; this version fixes the design issues that where made
 * in the first version. As these design changes are Major, we where not able to just modify the original version,
 * as this violates our Policy on Breaking Changes.
 *
 * However, we marked the original Directory API as deprecated, this means it will be removed with release 5.0.0.
 *
 * This version will be copied to the old Directory location and marked as deprecated with 5.1.0.
 *
 * Please read our CHANGELOG and Compatibility Documents for more information.
 *
 * @since 4.1.0
 * @author Thomas Obernosterer
 */
@Experimental
class Directory2(val path: String) {
    private val files: MutableList<File> = ArrayList()
    private val directories: MutableList<Directory2> = ArrayList()
    private val fileCache: MutableMap<String, ByteArray> = HashMap()

    init {
        scan()
    }

    /**
     * Find and add every file and directory in the given base directory path
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun scan() {
        val f = path.asFile()
        val fileList = f.listFiles()

        if (f.isDirectory && fileList != null) {
            files.clear()
            directories.clear()

            for (file in fileList) {
                if (file.isFile) {
                    files.add(file)
                } else if (file.isDirectory) {
                    directories.add(Directory2(file.path))
                }
            }
        }
    }

    /**
     * Add a File to the Directory
     *
     * @param file File to add
     * @param allowOverride If true, allows to override/reload existing files; If false returns an error
     * @return ==0 on Success; >=1 on Error
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun add(file: File, allowOverride: Boolean = false): DirectoryError {
        val hasFile = files.find { it.absolutePath == file.absolutePath } != null

        if (hasFile && !allowOverride) {
            return DirectoryError.FileKnownButOverrideDisallowed
        }

        if (hasFile) {
            files.removeIf { it.absolutePath == file.absolutePath }
        }

        files.add(file)
        fileCache[file.name] = file.readBytes()

        return DirectoryError.None
    }

    /**
     * Add a Directory to the base Directory
     *
     * @param directory2 Directory to add
     * @param allowOverride If true, allows to override/reload existing Subdirectories; If false reutrns an error
     * @return ==0 on Success; >=1 on Error
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun add(directory2: Directory2, allowOverride: Boolean = false): DirectoryError {
        val hasDirectory = directories.find { it.path == directory2.path } != null

        if (hasDirectory && !allowOverride) {
            return DirectoryError.DirectoryKnownButOverrideDisallowed
        }

        if (hasDirectory) {
            directories.removeIf { it.path == directory2.path }
        }

        directory2.scan()
        directories.add(directory2)

        return DirectoryError.None
    }

    /**
     * Find a file in the Base Folder
     *
     * @param predicate Predicate to find the file with
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun findFile(predicate: (File) -> Boolean): File? {
        return files.find(predicate)
    }

    /**
     * Get all Files
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun allFiles() = files

    /**
     * Get all Directories
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun allDirectories() = directories

    /**
     * Get last File
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun lastFile() = files.last()

    /**
     * Get last Directory
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun lastDirectory() = directories.last()

    /**
     * Find a Directory2 in the Base Folder
     *
     * @param predicate Predicate to find the Directory with
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun findDirectory(predicate: (String) -> Boolean): Directory2? {
        for (f in directories) {
            if (predicate(f.path)) {
                return f
            }
        }

        return null
    }

    /**
     * Update a File and write the new content to Disk
     *
     * @param fileName File to override
     * @param fileContent New file content
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun updateSync(fileName: String, fileContent: ByteArray) {
        val file = files.find { it.name == fileName }
        if (fileName in fileCache && file != null) {
            fileCache[fileName] = fileContent
            file.writeBytes(fileContent)
        }
    }

    /**
     * Update a File in cache
     *
     * @param fileName File to Override
     * @param fileContent New file content
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun update(fileName: String, fileContent: ByteArray) {
        val file = files.find { it.name == fileName }
        if (fileName in fileCache && file != null) {
            fileCache[fileName] = fileContent
        }
    }

    /**
     * Errors that can occur
     *
     * 0 means No Error, everything was fine
     * 1 means Not allowed to Override File
     * 2 means Not allowed to Override Directory
     */
    enum class DirectoryError(status: Int) {
        None(0), // No Error occurred, everything is fine
        FileKnownButOverrideDisallowed(1),
        DirectoryKnownButOverrideDisallowed(2)
    }
}
