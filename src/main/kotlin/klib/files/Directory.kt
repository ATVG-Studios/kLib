package klib.files

import java.io.File
import java.io.FileNotFoundException
import klib.extensions.readAll
import klib.extensions.replaceAllOf

/**
 * Enhanced Directory API
 *
 * @param directoryPath The path of the directory
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
@Deprecated(message = "This API has been replaced with Directory2 which fixes major design flaws",
    replaceWith = ReplaceWith("Directory2", imports = arrayOf("klib.files.Directory2")),
    level = DeprecationLevel.WARNING)
class Directory(val directoryPath: String) {
    private val files: MutableList<File> = ArrayList()
    private val filesContent: HashMap<String, String> = HashMap()

    init {
        val directory = File(directoryPath)

        fun addDirectory(direct: File) {
            // If given path exists and is directory
            if (direct.exists()) {
                if (direct.isDirectory) {
                    direct.listFiles()?.forEach {
                        // Recursively call add
                        addDirectory(it)
                    }
                }
                if (direct.isFile) {
                    // Add as file
                    addFile(direct)
                }
            }
        }

        // Start recursive load
        addDirectory(directory)

        // Read all the files content
        readAll()
    }

    /**
     * Add one file to the Directory
     *
     * @param file The file to add
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun addFile(newFile: File) {
        var found = false

        for (i in 0 until files.size) {
            val file = files[i]
            // File in cache
            if (file.name == newFile.name) {
                // override file
                files[i] = file

                found = true
                break
            }
        }

        // File not found in cache
        if (!found) {
            // add to cache
            files.add(newFile)
        }

        // Read content of file
        filesContent[newFile.name] = newFile.readText()
    }

    /**
     * Add multiple files to the Directory
     *
     * @param fileList The list of files
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun addFiles(vararg fileList: File) {
        fileList.forEach { addFile(it) }
    }

    /**
     * Add multiple files to the Directory
     *
     * @param filesList The list of files
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun addFiles(filesList: List<File>) {
        filesList.forEach { addFile(it) }
    }

    /**
     * Get all files
     *
     * @return List of all files
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun all(): List<File> = files

    /**
     * Get one File by index
     *
     * @param index The index of the file
     * @return The File
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun get(index: Int) = files[index]

    /**
     * Get the first file
     *
     * @return The File
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun first() = files.first()

    /**
     * Get the last file
     *
     * @return The File
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun last() = files.last()

    /**
     * Read one File from the Directory
     *
     * @param fileName The file to read
     * @param forceNewRead Forces to read the file, causes the file to be added to the directory if not existent
     * @return The content of the file as nullable String
     *
     * @throws FileNotFoundException
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun readOne(fileName: String, forceNewRead: Boolean = false): String? {
        /**
         * Local only function to read one files content
         *
         * @param file The File to read
         * @return The content of the file as nullable String
         *
         * @since 4.0.0
         * @author Thomas Obernosterer
         */
        fun readFile(file: File): String? {
            filesContent[file.name] = file.readText()
            return filesContent[file.name]
        }

        // Find the file in the directory
        val file = files.find { it.name == fileName }

        // If read is forced
        if (forceNewRead) {
            // and file exists in the directory
            return if (file != null) {
                // Read the file
                readFile(file)
            } else {
                // Add the file to the directory
                val newFile = File(fileName)
                addFile(newFile)

                // and read its content
                readFile(newFile)
            }
        }

        return when {
            // File content already cached, return it
            fileName in filesContent -> filesContent[fileName]
            // File not null but in directory, read it
            file != null -> readFile(file)
            else -> {
                // File was not found in the directory (dont just force add as it would be unexpected behavior)
                throw FileNotFoundException(fileName)
            }
        }
    }

    /**
     * Read all files contents
     *
     * @return HashMap with file name and content
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun readAll(): HashMap<String, String> {
        filesContent.apply { files.readAll() }
        return filesContent
    }

    /**
     * Replace all in all file contents
     *
     * @param search The string to replace
     * @param replace The string to replace with
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun replaceAll(search: String, replace: String) {
        files.replaceAllOf(search, replace)
    }

    /**
     * Write all files back to disk
     *
     * @param enableGitShield Dont write files in .git folder to prevent corruption
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun writeAll(enableGitShield: Boolean = true) {
        for (file in files) {
            if (!file.exists()) {
                throw FileNotFoundException(file.name)
            }

            if (!file.isFile) {
                continue
            }

            if (!file.canWrite()) {
                continue
            }

            // Ignore .git folder to prevent repository corruption
            if (file.path.contains(".git") && enableGitShield) {
                continue
            }

            val fileContent = filesContent[file.name] ?: ""

            println("File: ${file.name}; Path: ${file.path}; Content: $fileContent")

            file.writeText(fileContent)
        }
    }

    /**
     * Find all files with one extension
     *
     * @param extension The extension to search for
     * @return The list of files
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun findWithExtension(extension: String): List<File> {
        val filesWithExt: MutableList<File> = ArrayList()

        files.forEach {
            if (it.extension == extension) {
                filesWithExt.add(it)
            }
        }

        return filesWithExt
    }
}
