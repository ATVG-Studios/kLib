package klib.exceptions

/**
 * Custom exception
 *
 * @param required
 * @param inString
 * @param type
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
class RequireValueException(required: String, inString: String, type: String = "String") : Exception("$type '$required' is required in value '$inString'")