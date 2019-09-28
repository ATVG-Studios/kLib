package klib.library

/**
 * Library Data Wrapper class for DSLs
 *
 * @param file The file to load from
 * @param className The class to load
 * @param functionName The function to load
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
class LibLoad(var file: String = "", var className: String = "", var functionName: String = "")