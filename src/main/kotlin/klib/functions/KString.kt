package klib.functions

import klib.text.KString

/**
 * StringBuilder DSL
 *
 * @param builder Receiver of KString Builder
 * @return Build String
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
fun kstring(builder: KString.() -> Unit): String {
    return KString().apply(builder).toString()
}