package com.atvgstudios.klib.objects.uuid

import java.util.UUID

/**
 * Custom UUID Wrapper
 *
 * @see java.util.UUID
 *
 * @since 0.1.0
 * @author Thomas Obernosterer
 */
object UniqueID {
    /**
     * Simple property wrapper around UUID
     *
     * @see java.util.UUID
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    val random
        get() = UUID.randomUUID().toString()

    /**
     * Publicly Read-Only last id created with new()
     * @see new()
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    var lastId: String = ""
        private set

    /**
     * Get a new Random UUID and store it in lastId
     *
     * @return
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    fun new(): String {
        lastId = random
        return lastId
    }
}
