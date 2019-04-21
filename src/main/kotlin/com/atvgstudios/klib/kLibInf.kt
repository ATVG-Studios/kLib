package com.atvgstudios.klib

import com.atvgstudios.klib.annotations.Author

@Author(name = "Thomas Obernosterer")
object kLibInf {
    const val name = "ATVG-Studios Kotlin Std Library"
    const val versionId = 2 // A unique version number used to identify releases and to make easy requirement checks
    const val version = "0.1.1"
    const val company = "ATVG-Studios"
    const val license = "MIT"
    val authors = arrayListOf(
        // Format: Name <Email> (Company, Homepage)
        "Thomas Obernosterer <thomas.obernosterer@atvg-studios.com> (ATVG-Studios, https://atvg-studios.com)"
    )
}