package klib.extensions

import java.lang.reflect.Modifier

/**
 * Checks if the given modifier is one of:
 *
 * Public, Private, Protected or Native
 *
 * @return True when any of the above modifiers matches; False otherwise
 */
fun Int.isCallableMethodModifier(): Boolean {
    return Modifier.isProtected(this) ||
        Modifier.isPrivate(this) ||
        Modifier.isPublic(this) ||
        Modifier.isNative(this)
}
