package klib.exceptions

/**
 * Custom exception
 *
 * @param notAllowed
 * @param inString
 * @param type
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
class InvalidValueException(notAllowed: String, inString: String, type: String = "String") :
    Exception("$type '$notAllowed' is not allowed in value '$inString'")
