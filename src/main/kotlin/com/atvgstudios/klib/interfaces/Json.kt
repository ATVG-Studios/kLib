package com.atvgstudios.klib.interfaces

import java.lang.reflect.Type

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
     * Convert Json to Object
     *
     * @deprecated since 0.1.5
     * @since 0.1.3
     * @author Thomas Obernosterer
     */
    @Deprecated("Has been replaced with toObject(String, Type): Any?", level = DeprecationLevel.ERROR)
    fun toObject(data: String, type: Any): Any

    /**
     * Convert Json to Type
     *
     * @param data The Json String
     * @param type The target Type
     * @return Type as Any if data is parsable; Otherwise null
     *
     * @since 0.1.5
     * @author Nils Rider
     */
    fun toObject(data: String, type: Type): Any?
}