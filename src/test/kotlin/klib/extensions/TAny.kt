package klib.extensions

import com.atvgstudios.klib.extensions.ofType
import org.junit.Test

open class Animal(val name: String)

class Dog(name: String) : Animal(name)

class TAny {
    @Test
    fun ofType(){
        var success = false

        var peter = Animal("Peter")
        peter = Dog("Peter")

        peter.ofType<Dog> {
            success = it.name == "Peter"
        }

        assert(success)
    }
}