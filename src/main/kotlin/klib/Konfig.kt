package klib

import java.io.File
import klib.exceptions.KonfigParseException
import klib.extensions.replaceLast

/**
 * Custom Configuration reader and generator
 *
 * @since 0.2.2 (Experimental)
 * @since 2.0.0
 * @author Thomas Obernosterer
 */
object Konfig {

    /**
     * Parse a whole file by file name
     *
     * @param name The file to parse
     *
     * @since 0.2.2
     * @author Thomas Obernosterer
     */
    fun parseFile(name: String): Map<String, Any> {
        return parseFile(File(name))
    }

    /**
     * Parse a whole file by file object
     *
     * @param file The file to parse
     *
     * @since 0.2.2
     * @author Thomas Obernosterer
     */
    fun parseFile(file: File): Map<String, Any> {
        if (!file.canRead()) throw KonfigParseException("The file ${file.name} cannot be read!")
        return parse(file.readLines())
    }

    /**
     * Parse a data string (Split at newLine for multiple-values)
     *
     * @param data The string data to split
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun parseString(data: String): Map<String, Any> {
        return parse(data.split("\n"))
    }

    /**
     * Parse a List<String> into a Map<String, Any>
     *
     * @param data The data to parse
     * @return The parsed data
     *
     * @since 0.2.2 (Konfig 19.2)
     * @since 4.1.0 (Konfig 20.2)
     * @author Thomas Obernosterer
     */
    @UseExperimental(ExperimentalUnsignedTypes::class)
    fun parse(data: List<String>): Map<String, Any> {
        val result: MutableMap<String, Any> = HashMap()
        var line = 0
        val totalLines = data.size
        data.forEach {
            line++
            if (it.startsWith("#")) return@forEach
            if (it.isEmpty()) return@forEach

            if (!it.contains("=")) throw KonfigParseException("Cannot parse line $line of $totalLines")

            val d = it.split("=")
            val key = d[0]

            if (key in result) throw KonfigParseException("Cannot use duplicate key on line $line of $totalLines")

            val value = d.joinToString("=").replaceFirst("$key=", "")

            result[key] = parseValue(value)
        }
        return result
    }

    @ExperimentalUnsignedTypes
    private fun parseValue(value: String): Any {
        return when {
            value.startsWith("[") -> {
                val valueArray = value.replaceFirst("[", "")
                    .replaceLast("]", "").split(",")

                val valueList: MutableList<Any> = ArrayList()

                valueArray.forEach {
                    valueList.add(parseValue(it))
                }

                valueList // Return
            }
            value.startsWith("{") -> {
                val valueList = value.replaceFirst("[", "")
                    .replaceLast("]", "").split(",")

                val valueMap: MutableMap<String, Any> = HashMap()

                valueList.forEach { pairString ->
                    val pairValue = pairString.split(":")
                    valueMap[pairValue[0]] = parseValue(pairValue[1])
                }

                valueMap // Return
            }
            value.toLowerCase() == "true" -> true
            value.toLowerCase() == "false" -> false
            value.startsWith("U") -> {
                value.replace("U", "").toUIntOrNull() ?: 0
            }
            else -> value
        }
    }

    /**
     * Create and write data to a file
     *
     * @param data The data to write
     * @param fileName The file to write to
     *
     * @since 0.2.2
     * @author Thomas Obernosterer
     */
    fun writeFile(data: Map<String, Any>, fileName: String) {
        val file = File(fileName)
        if (!file.exists()) file.createNewFile()
        writeFile(data, File(fileName))
    }

    /**
     * Create and write data to a file
     *
     * @param data The data to write
     * @param file The file to write to
     *
     * @since 0.2.2
     * @author Thomas Obernosterer
     */
    fun writeFile(data: Map<String, Any>, file: File) {
        if (!file.canWrite()) throw Exception("Cannot write to file ${file.name}")

        file.writeText(createKonfig(data).joinToString("\n"))
    }

    /**
     * Convert a Map<String, Any> into a List<String>
     *
     * @param data The data to convert
     * @return The converted Data
     *
     * @since 0.2.2
     * @author Thomas Obernosterer
     */
    fun createKonfig(data: Map<String, Any>): List<String> {
        val writableData: MutableList<String> = ArrayList()

        data.forEach {
            writableData.add("${it.key}=${it.value}")
        }

        return writableData
    }
}
