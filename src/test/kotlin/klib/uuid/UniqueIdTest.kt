package klib.uuid

import kotlin.test.Test
import kotlin.test.assertEquals

class UniqueIdTest {
    @Test
    fun `Get random UUID 4 with new()`() {
        val newUUID = UniqueID.new()
        assert(newUUID.isNotEmpty())
    }

    @Test
    fun `Get random UUID 4 with random`() {
        val newUUID = UniqueID.random
        assert(newUUID.isNotEmpty())
    }

    @Test
    fun `Get last random UUID 4`() {
        val newUUID = UniqueID.new()
        val lastUUID = UniqueID.lastId
        assertEquals(newUUID, lastUUID)
    }
}
