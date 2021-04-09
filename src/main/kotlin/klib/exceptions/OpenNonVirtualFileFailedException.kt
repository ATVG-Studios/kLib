package klib.exceptions

/**
 * Custom exception
 *
 * @since 5.1.0
 * @author Thomas Obernosterer
 */
class OpenNonVirtualFileFailedException :
    Exception("OpenNonVirtualFileFailed: Cannot open a non-virtual ZipFile without a name or path")
