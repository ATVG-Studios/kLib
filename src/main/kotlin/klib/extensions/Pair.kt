package klib.extensions

import klib.exceptions.InvalidValueException

/**
 * Run String.deny on a String Pair
 *
 * @param str Not allowed String
 * @throws InvalidValueException If str is inside the String
 * @see String.deny
 *
 * @since 1.1.0
 * @author Nils Rider
 */
infix fun Pair<String, String>.deny(str: String) {
    first deny str
    second deny str
}

/**
 * Run String.require on a String Pair
 *
 * @param str Required String
 * @throws InvalidValueException If str is not inside the String
 * @see String.require
 *
 * @since 1.1.0
 * @author Nils Rider
 */
infix fun Pair<String, String>.require(str: String) {
    first require str
    second require str
}
