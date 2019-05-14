package klib.exceptions

/**
 * Custom exception
 *
 * @param reason
 *
 * @since <NEXT_VERSION>
 * @author Thomas Obernosterer
 */
class KonfigParseException(reason: String) : Exception("KonfigParseException: Cannot parse konf; Reason: $reason")