package klib.extensions

import org.junit.Test

class TList {
    @Test
    fun quicksort() {
        val data = listOf("Tim", "Steve", "Zack", "Adam", "John", "Peter", "Clark")
        val data2 = data.quicksort()
        assert(data2 == listOf("Adam", "Clark", "John", "Peter", "Steve", "Tim", "Zack"))
    }
}
