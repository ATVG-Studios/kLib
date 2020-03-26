package klib.extensions

import org.junit.Test

class TMutableList {
    @Test
    fun quicksort() {
        val data = mutableListOf("Tim", "Steve", "Zack", "Adam", "John", "Peter", "Clark")
        data.quicksort()
        assert(data == listOf("Adam", "Clark", "John", "Peter", "Steve", "Tim", "Zack"))
    }
}
