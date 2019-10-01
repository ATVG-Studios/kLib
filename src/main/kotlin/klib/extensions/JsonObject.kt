package klib.extensions

import net.jemzart.jsonkraken.values.JsonObject

inline fun <reified T> JsonObject.toObjectOfType(): T? {
    if (this is T)
        return this
    return null
}