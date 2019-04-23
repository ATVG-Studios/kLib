package com.atvgstudios.klib.objects.uuid

import java.util.UUID

/**
 * Custom UUID Wrapper
 *
 * @see java.util.UUID
 */
object UniqueID {
    val random
        get() = UUID.randomUUID().toString()
    var lastId: String = ""
        private set

    /**
     * Get a new Random UUID and store it in lastId
     *
     * @return
     */
    fun new(): String {
        lastId = random
        return lastId
    }
}
