package net.jemzart.jsonkraken.exceptions

import net.jemzart.jsonkraken.values.JsonValue
/**
 * An exception used for operations that would incur in a circular reference.
 *
 * Logically, this can only occur when assigning a JsonValue to another.
 *
 * @property host the name of this group.
 * @property intruder the name of this group.
 */
class CircularReferenceException(
    val host: JsonValue,
    val intruder: JsonValue
) :
    Exception("Performing the operation would incur in a circular reference.")
