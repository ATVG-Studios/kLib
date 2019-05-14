package klib.exceptions

/**
 * Custom exception
 *
 * @param reason
 *
 * @deprecated Since <NEXT_VERSION>
 *
 * @since 0.2.2
 * @author Thomas Obernosterer
 */
@Deprecated("Was replaced with a better named version", replaceWith = ReplaceWith("KonfigParseException"), level = DeprecationLevel.WARNING)
class KonfParseException(reason: String) : Exception("KonfParseException: Cannot parse konf; Reason: $reason")