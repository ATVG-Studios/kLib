package klib.extensions

import org.junit.Test

open class Animal(val name: String, val isAnimal: Boolean = true)

class Dog(name: String, val isDog: Boolean = true) : Animal(name)

class TAny {
    @Test
    fun ofType(){
        var success = false

        val peter: Animal = Dog("Peter")

        peter.ofType<Dog> {
            success = it.isAnimal && it.isDog
        }

        assert(success)
    }

    @Test
    fun or() {
        val test: Any? = null
        assert(test or true == true)
    }

    @Test
    fun orFun() {
        val test: Any? = null
        assert(test orFun {
            true
        } == true)
    }
}