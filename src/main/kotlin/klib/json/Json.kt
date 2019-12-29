package klib.json

import net.jemzart.jsonkraken.values.JsonArray

/**
 * Common JSON Parser Interface
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
interface Json {
    /**
     * Convert Object to Json
     *
     * @since 0.1.3
     * @author Thomas Obernosterer
     */
    fun fromObject(data: Any): String

    /**
     * Convert Json to Any
     *
     * @param data The Json String
     * @return Type as Any if data is parsable; Otherwise null
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun toObject(data: String): Any?

    /**
     * Convert Json to JsonArray
     *
     * @param data The Json String
     * @return Type as Any if data is parsable; Otherwise null
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun toArray(data: String): JsonArray?
}
