package klib.exceptions

/**
 * Custom exception
 *
 * @param reason
 *
 * @since 0.2.2
 * @author Thomas Obernosterer
 */
class KonfParseException(reason: String) : Exception("KonfParseException: Cannot parse konf; Reason: $reason")