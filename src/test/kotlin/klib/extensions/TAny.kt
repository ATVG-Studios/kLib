/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.extensions

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

open class Animal(val name: String, val isAnimal: Boolean = true)

class Dog(name: String, val isDog: Boolean = true) : Animal(name)

data class DemoModelA(var name: String = "emptyA")
data class DemoModelB(var name: String = "emptyB")

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
    fun copyFrom() {
        val source = DemoModelA("Hello")
        val target = DemoModelB()

        target.copyFrom(source)

        assertEquals(source.name, target.name)
    }
}
