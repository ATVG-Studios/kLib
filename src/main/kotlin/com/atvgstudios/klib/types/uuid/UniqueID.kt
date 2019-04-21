package com.atvgstudios.klib.types.uuid

import com.atvgstudios.klib.annotations.*
import java.util.*

@Author(name = "Thomas Obernosterer", email = "thomas.obernosterer@atvg-studios.com", company = "ATVG-Studios", homepage = "https://atvg-studios.com")
object UniqueID{
    val random
        get() = UUID.randomUUID().toString()
    var lastId: String = ""
        private set

    fun new(): String{
        lastId = random
        return lastId
    }
}
