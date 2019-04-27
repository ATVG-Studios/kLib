package com.atvgstudios.klib.objects.json

import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.stringify

/**
 * Custom Tiny kotlinx.serialization wrapper
 *
 * @since 0.1.2
 * @author Thomas Obernosterer
 */
@Deprecated("This API interface will be removed; Use kotlinx.serialization instead!", ReplaceWith("Json", "kotlinx.serialization.json.Json"), DeprecationLevel.ERROR)
object Json {
    /**
     * Convert Any to Json
     *
     * @param data
     * @return
     *
     * @since 0.1.2
     * @author Thomas Obernosterer
     */
    @UseExperimental(ImplicitReflectionSerializer::class)
    fun fromObject(data: Any): String {
        return Json.stringify(data)
    }
}