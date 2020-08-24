package klib.extensions

import org.junit.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull

open class Animal(val name: String, val isAnimal: Boolean = true)

class Dog(name: String, val isDog: Boolean = true) : Animal(name)

class TAny {
    @Test
    fun ofType() {
        var success = false

        val peter: Animal = Dog("Peter")

        peter.ofType<Dog> {
            success = it.isAnimal && it.isDog
        }

        assert(success)
    }

    @Test
    fun or() {
        val test: Boolean? = null
        assertNotNull(test or true)
    }

    @Test
    fun orNullable() {
        val test: String? = null
        assertNull(test orNullable null)
    }

    @Test
    fun orFun() {
        val test: Any? = null
        assert(
            test orFun {
                true
            } == true
        )
    }
}
