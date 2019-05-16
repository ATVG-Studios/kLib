package klib.exceptions

/**
 * Custom exception
 *
 * @param reason
 *
 * @since 1.1.0
 * @author Thomas Obernosterer
 */
class KonfigParseException(reason: String) : Exception("KonfigParseException: Cannot parse konf; Reason: $reason")