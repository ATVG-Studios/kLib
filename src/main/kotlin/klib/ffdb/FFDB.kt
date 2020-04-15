package klib.ffdb

import java.io.File
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.OutputStream
import java.lang.Exception
import klib.annotations.Experimental
import klib.exceptions.IncompatibleDatabaseException
import klib.extensions.asFile
import klib.extensions.objectInputStream
import klib.extensions.objectOutputStream

/**
 * FlatFile DataBase
 *
 * A simple Database format that stores objects data into one file
 *
 * @param storageFile The file to read/write from/to
 * @param schemaVersion Version of the File (V2 supports ReadAll)
 *
 * @since 5.0.0 (Experimental)
 * @author Thomas Obernosterer
 */
@Experimental
class FFDB(val storageFile: File, val schemaVersion: Int = Version.V2.version) {
    private val writeBuffer: MutableList<Any> = ArrayList()

    /**
     * Read only access to Buffer
     *
     * @since 5.0.0
     * @author Thomas Obernosterer
     */
    val buffer: List<Any>
    get() = writeBuffer

    companion object {
        /**
         * Open Database
         *
         * @param path Path to File
         *
         * @since 5.0.0
         * @author Thomas Obernosterer
         */
        fun open(path: String, version: Int = Version.V2.version): FFDB = FFDB(path.asFile(), version)
        /**
         * Open Database
         *
         * @param file File handle
         *
         * @since 5.0.0
         * @author Thomas Obernosterer
         */
        fun open(
            file: File = File.createTempFile("klib.ffdb-database", ".ffdb"),
            version: Int = Version.V2.version
        ): FFDB = FFDB(file, version)
    }

    /**
     * Initialize the Database
     *
     * + Automatically reads all data into the buffer in case Database Version 2 is used
     *
     * @since 5.0.0
     * @author Thomas Obernosterer
     */
    init {
        if (!storageFile.exists()) {
            storageFile.createNewFile()
        }

        if (storageFile.length() > 0) {
            when (schemaVersion) {
                Version.V2.version -> preloadV2()
            }
        }
    }

    /**
     * Add Object to Write Buffer
     *
     * @since 5.0.0
     * @author Thomas Obernosterer
     */
    fun write(data: Any) {
        writeBuffer.add(data)
    }

    /**
     * Add Array to Write Buffer
     *
     * @since 5.0.0
     * @author Thomas Obernosterer
     */
    fun writeAll(data: Array<Any>) {
        data.forEach {
            writeBuffer.add(it)
        }
    }

    /**
     * Add List to Write Buffer
     *
     * @since 5.0.0
     * @author Thomas Obernosterer
     */
    fun writeAll(data: List<Any>) {
        data.forEach {
            writeBuffer.add(it)
        }
    }

    /**
     * Remove object from buffer based on Predicate
     *
     * @param predicate Predicate to check what shall be removed
     *
     * @since 5.0.0
     * @author Thomas Obernosterer
     */
    fun remove(predicate: (Any) -> Boolean) {
        writeBuffer.removeIf(predicate)
    }

    /**
     * Remove object from buffer based on Index
     *
     * @param index Index to remove
     * @return Object that was removed from the Buffer
     *
     * @since 5.0.0
     * @author Thomas Obernosterer
     */
    fun removeAt(index: Int): Any? {
        return writeBuffer.removeAt(index)
    }

    /**
     * Write objects to Database
     *
     * @since 5.0.0
     * @author Thomas Obernosterer
     */
    fun flush() {
        if (writeBuffer.isEmpty()) {
            return
        }
        when (schemaVersion) {
            Version.V1.version -> writeV1(storageFile.objectOutputStream())
            Version.V2.version -> writeV2(storageFile.objectOutputStream())
        }
    }

    /**
     * Write objects to custom Stream
     *
     * @param stream Output Stream target
     *
     * @since 5.0.0
     * @author Thomas Obernosterer
     */
    fun flushToStream(stream: OutputStream) {
        if (writeBuffer.isEmpty()) {
            return
        }
        when (schemaVersion) {
            Version.V1.version -> writeV1(ObjectOutputStream(stream))
            Version.V2.version -> writeV2(ObjectOutputStream(stream))
        }
    }

    /**
     * Clear the internal write buffer
     *
     * @since 5.0.0
     * @author Thomas Obernosterer
     */
    fun clearBuffer() {
        writeBuffer.clear()
    }

    /**
     * Read one Object from Database
     *
     * @since 5.0.0
     * @author Thomas Obernosterer
     */
    fun readOne(): Any? {
        return when (schemaVersion) {
            Version.V1.version -> readV1(storageFile.objectInputStream())
            Version.V2.version -> readV2(storageFile.objectInputStream())
            else -> null
        }
    }

    /**
     * Read all Object from Database
     *
     * :Requires Database V2
     *
     * @since 5.0.0
     * @author Thomas Obernosterer
     */
    fun readAll(): List<Any?> {
        return when (schemaVersion) {
            Version.V1.version -> throw IncompatibleDatabaseException(schemaVersion.toString(), "2")
            Version.V2.version -> readAllV2(storageFile.objectInputStream())
            else -> ArrayList()
        }
    }

    /**
     * Database Version
     *
     * @param version Version Number as Int
     */
    enum class Version(val version: Int) {
        V1(1),
        V2(2);
    }

    // ////// Version 1 ////////

    private fun writeV1(stream: ObjectOutputStream) = with(stream) {
        writeInt(Version.V1.version)

        writeBuffer.forEach {
            writeObject(it)
        }

        writeBuffer.clear()
    }

    private fun readV1(stream: ObjectInputStream): Any = with(stream) {
        val ver = readInt()

        if (ver == Version.V1.version) {
            return readObject()
        }
    }

    // ////// Version 2 ////////

    private fun writeV2(stream: ObjectOutputStream) = with(stream) {
        writeInt(Version.V2.version)
        writeInt(writeBuffer.size)

        writeBuffer.forEach {
            writeObject(it)
        }

        writeBuffer.clear()
    }

    private fun readV2(stream: ObjectInputStream): Any = with(stream) {
        val ver = readInt()

        // Buffer Size, Ignore this for reading just one
        readInt()

        if (ver == Version.V2.version) {
            return readObject()
        }
    }

    private fun readAllV2(stream: ObjectInputStream): List<Any?> {
        val ver = stream.readInt()
        var size = stream.readInt()

        if (ver == Version.V2.version) {
            val objects: MutableList<Any?> = ArrayList()

            while (size > 0) {
                objects.add(stream.readObject())
                size--
            }

            return objects
        }

        return ArrayList()
    }

    private fun preloadV2() {
        try {
            val data = readAllV2(storageFile.objectInputStream())
            data.forEach {
                if (it != null) {
                    writeBuffer.add(it)
                }
            }
        } catch (e: Exception) {
            println("Cannot preload FFDB Buffer due to the following error, proceeding with empty Buffer.")
            clearBuffer()
            e.printStackTrace()
        }
    }
}
