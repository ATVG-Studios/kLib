package com.atvgstudios.klib.annotations

/**
 * Author: Thomas Obernosterer
 */

annotation class Author(val name: String, val email: String = "", val company: String = "", val homepage: String = "")
annotation class ModifiedBy(val authors: Array<Author>)