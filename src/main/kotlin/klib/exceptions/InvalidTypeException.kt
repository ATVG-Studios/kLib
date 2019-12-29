package klib.exceptions

/**
 * Custom exception
 *
 * @param cannotHandle
 * @param asType
 *
 * @since 2.0.0
 * @author Thomas Obernosterer
 */
class InvalidTypeException(cannotHandle: String, asType: String) : Exception("Cannot use $cannotHandle as $asType")
