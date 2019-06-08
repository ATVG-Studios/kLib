package klib.extensions

/**
 * Merge a Map into a MutableMap without overwriting existing keys
 *
 * @param other The map to merge
 *
 * @since 3.0.0
 * @author Thomas Obernosterer
 */
fun <K, V> MutableMap<K, V>.smartMerge(other: Map<K, V>) {
    other.forEach { (key, value) ->
        if (key !in this) {
            this[key] = value
        }
    }
}

/**
 * Merge a Key and a Value Array into a MutableMap; Duplicate keys will be ignored
 *
 * @param keys The Keys
 * @param values The Values
 *
 * @since 3.0.0
 * @author Thomas Obernosterer
 */
fun <K, V> MutableMap<K, V>.mergeArrays(keys: Array<K>, values: Array<V>) {
    if (keys.size == values.size) {
        for (i in 0 until keys.size) {
            if (keys[i] !in this) {
                this[keys[i]] = values[i]
            }
        }
    }
}

/**
 * Merge a Map into a MutableMap with overwriting existing keys
 *
 * @param other The map to merge
 *
 * @since 3.0.0
 * @author Thomas Obernosterer
 */
fun <K, V> MutableMap<K, V>.fullMerge(other: Map<K, V>) {
    other.forEach { (key, value) ->
        this[key] = value
    }
}