package klib.functions

import klib.text.KString

fun kstring(builder: KString.() -> Unit): String {
    return KString().apply(builder).toString()
}