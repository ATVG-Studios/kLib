package com.atvgstudios.klib.interfaces

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
     * @since 0.1.3
     * @author Thomas Obernosterer
     */
    fun toObject(data: String, type: Any): Any
}