package klib.exceptions

import java.lang.Exception

/**
 * Custom exception
 *
 * @param filePath
 *
 * @since 5.1.0
 * @author Thomas Obernosterer
 */
class ZipTraversalNotAllowedException(filePath: String) : Exception("ZipFile found a path that seems to try to traverse out of the Zip Package: $filePath")
