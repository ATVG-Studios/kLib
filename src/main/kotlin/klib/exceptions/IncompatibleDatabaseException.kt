package klib.exceptions

/**
 * Custom exception
 *
 * @param current
 * @param required
 *
 * @since 5.0.0
 * @author Thomas Obernosterer
 */
class IncompatibleDatabaseException(current: String, required: String) : Exception("Database with version $current cannot perform a version $required action!")
