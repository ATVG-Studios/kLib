package klib.exceptions

/**
 * Custom exception
 *
 * @param fileName File that was not writable
 *
 * @since 6.0.0
 * @author Thomas Obernosterer
 */
class FileNotWritableException(fileName: String) : Exception("Cannot write to file: '$fileName'")
