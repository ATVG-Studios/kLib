package klib.functions

import klib.KString

fun kstring(builder: KString.() -> Unit): String {
    return KString().apply(builder).toString()
}