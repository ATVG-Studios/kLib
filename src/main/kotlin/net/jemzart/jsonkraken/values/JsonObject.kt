package net.jemzart.jsonkraken.values

import net.jemzart.jsonkraken.helpers.purify
import net.jemzart.jsonkraken.helpers.references
import net.jemzart.jsonkraken.helpers.validate
import net.jemzart.jsonkraken.toJsonObject

/**
 * @constructor empty json object.
 */
class JsonObject() : JsonValue, Iterable<Pair<String, Any?>> {
    /**
	 * @constructor json object filled with [properties].
	 * Pair second values must be of valid types (See 'Valid Types').
	 */
    constructor(vararg properties: Pair<String, Any?>) : this() {
        for (property in properties) {
            property.first.validate()
            val purified = property.second.purify()
            map[property.first] = purified
        }
    }

    override val size: Int get() = map.size
    private val map: MutableMap<String, Any?> = mutableMapOf()

    /**
	 * @return an iterator over all its properties.
	 */
    override fun iterator(): Iterator<Pair<String, Any?>> = map.map { it.key to it.value }.iterator()
    override fun get(name: String): Any? = map[name]
    override fun set(name: String, value: Any?) {
        name.validate()
        map[name] = value.purify(this)
    }

    override fun remove(name: String) {
        map.remove(name)
    }

    override fun exists(name: String): Boolean {
        return map.containsKey(name)
    }

    /**
	 * @return a collection with all its property keys.
	 */
    val keys get() = map.keys

    /**
	 * @return a collection with all its property values.
	 */
    val values get() = map.values

    override fun clone(): JsonObject = map.map {
        val value = it.value
        it.key to if (value is JsonValue) value.clone() else value
    }.toMap().toJsonObject()

    internal fun uncheckedSet(name: String, value: Any?) = map.set(name, value)

    override fun references(value: JsonValue): Boolean = map.values.references(value)
}