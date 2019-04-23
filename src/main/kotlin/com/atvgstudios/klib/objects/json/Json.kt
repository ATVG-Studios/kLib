package com.atvgstudios.klib.objects.json

import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.stringify

/**
 * Custom Tiny kotlinx.serialization wrapper
 *
 * @see kotlinx.serialization
 */
object Json {
    /**
     * Convert Any to Json
     *
     * @see kotlinx.serialization.stringify
     * @param data
     * @return
     */
    @UseExperimental(ImplicitReflectionSerializer::class)
    fun fromObject(data: Any): String {
        return Json.stringify(data)
    }
}