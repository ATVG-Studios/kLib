package klib.extensions

import net.jemzart.jsonkraken.JsonArray

inline fun <reified T> JsonArray.toListOfType(): List<T> {
    val typeOf: MutableList<T> = ArrayList()

    this.forEach {
        if (it is T) {
            typeOf.add(it as T)
        }
    }

    return typeOf
}
