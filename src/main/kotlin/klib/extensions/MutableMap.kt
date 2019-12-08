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
 * Merge a Map into a MutableMap without overwriting existing keys
 *
 * @param other The map to merge
 * @param convertIt Converter function to put Any to type 2
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun <K, V> MutableMap<K, V>.smartMerge(other: Map<K, Any>, convertIt: (Any) -> V) {
    other.forEach { (key, value) ->
        if (key !in this) {
            this[key] = convertIt(value)
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
 * Merge a Key and a Value Array into a MutableMap; Duplicate keys will be ignored
 *
 * @param keys The Keys
 * @param values The Values
 * @param convertIt Converter function to put Any to type 2
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun <K, V> MutableMap<K, V>.mergeArrays(keys: Array<K>, values: Array<Any>, convertIt: (Any) -> V) {
    if (keys.size == values.size) {
        for (i in 0 until keys.size) {
            if (keys[i] !in this) {
                this[keys[i]] = convertIt(values[i])
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

/**
 * Merge a Map into a MutableMap with overwriting existing keys
 *
 * @param other The map to merge
 * @param convertIt Converter function to put Any to type 2
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun <K, V> MutableMap<K, V>.fullMerge(other: Map<K, Any>, convertIt: (Any) -> V) {
    other.forEach { (key, value) ->
        this[key] = convertIt(value)
    }
}
