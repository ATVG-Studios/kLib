package klib.exceptions

/**
 * Custom exception
 *
 * @param reason
 *
 * @deprecated Since 1.1.0
 *
 * @since 0.2.2
 * @author Thomas Obernosterer
 */
@Deprecated("Was replaced with a better named version", replaceWith = ReplaceWith("KonfigParseException"), level = DeprecationLevel.WARNING)
class KonfParseException(reason: String) : Exception("KonfParseException: Cannot parse konf; Reason: $reason")