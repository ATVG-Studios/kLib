package net.jemzart.jsonkraken

import net.jemzart.jsonkraken.helpers.purify
import net.jemzart.jsonkraken.parsers.Deserializer
import net.jemzart.jsonkraken.parsers.Serializer
import net.jemzart.jsonkraken.values.JsonArray
import net.jemzart.jsonkraken.values.JsonObject
import net.jemzart.jsonkraken.values.JsonValue

/**
 * @return easy way to convert an Iterable to a JsonArray.
 * @receiver an iterable containing only valid types (See 'Valid Types').
 */
fun Iterable<*>.toJsonArray(): JsonArray {
    val jsonArray = JsonArray()
    for (item in this) jsonArray.add(item)
    return jsonArray
}

/**
 * @return easy way to convert a map to a JsonObject.
 * @receiver a map containing only valid types (See 'Valid Types').
 */
fun Map<String, *>.toJsonObject(): JsonObject {
    val jsonObject = JsonObject()
    for (pair in this) jsonObject[pair.key] = pair.value
    return jsonObject
}

/**
 * @return an object representation of the receiver.
 * @receiver raw json data.
 */
fun String.toJson(): Any? = Deserializer(this).create()

/**
 * @param formatted if false, needless blank spaces will be removed, if true, the result will be more human readable.
 * @return an json string representation of the receiver.
 * @receiver an object of any valid type (See 'Valid Types').
 */
fun Any?.toJsonString(formatted: Boolean = false): String {
    return Serializer(this.purify(), formatted).create()
}

/**
 * @return the value of the property named [name] in a JsonValue.
 * @receiver if JsonArray, [name] works as an index.
 * @exception <UnsupportedOperationException> if receiver is not a JsonValue.
 */
operator fun Any?.get(name: String): Any? =
    if (this is JsonValue) this[name]
    else throw UnsupportedOperationException()

/**
 * @return the element at index [index] in a JsonValue.
 * @receiver if JsonObject, [index] works as a property name.
 * @exception <UnsupportedOperationException> if receiver is not a JsonValue.
 */
operator fun Any?.get(index: Int): Any? =
    if (this is JsonValue) this[index]
    else throw UnsupportedOperationException()

/**
 * Sets [value] in a property named [name] in a JsonValue.
 * @receiver if JsonArray, [name] works as an index.
 * @exception <UnsupportedOperationException> if receiver is not a JsonValue.
 */
operator fun Any?.set(name: String, value: Any?) =
    if (this is JsonValue) this[name] = value
    else throw UnsupportedOperationException()

/**
 * Sets [value] in the selected [index] in a JsonValue.
 * @receiver if JsonObject, [index] works as a property name.
 * @exception <UnsupportedOperationException> if receiver is not a JsonValue.
 */
operator fun Any?.set(index: Int, value: Any?) =
    if (this is JsonValue) this[index] = value
    else throw UnsupportedOperationException()