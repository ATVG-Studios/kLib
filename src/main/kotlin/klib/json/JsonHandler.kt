package klib.json

import net.jemzart.jsonkraken.parsers.Deserializer
import net.jemzart.jsonkraken.parsers.Serializer
import net.jemzart.jsonkraken.values.JsonArray

/**
 * JsonHandler
 *
 * @since 3.2.0
 * @author Thomas Obernosterer
 */
class JsonHandler : Json {
    /**
     * Convert a Object to a JSON String
     *
     * @param data The Object to convert
     * @return string The JSON String
     *
     * @since 3.2.0
     * @author Thomas Obernosterer
     */
    override fun fromObject(data: Any): String {
        val ser = Serializer(data, false)
        return ser.create()
    }

    /**
     * Convert a JSON String to a Object
     *
     * @param data The JSON String
     * @return Any The Object
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    override fun toObject(data: String): Any? {
        val des = Deserializer(data)
        return des.create()
    }

    override fun toArray(data: String): JsonArray? {
        val obj = toObject(data)

        if (obj is JsonArray)
            return obj

        return null
    }
}