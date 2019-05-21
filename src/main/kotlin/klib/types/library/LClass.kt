package klib.types.library

/**
 * Custom Class to handle Dynamically loaded Classes
 *
 * @param sourceClass A Class<*> that serves as the Host for further use
 *
 * @since 1.3.0 (Experimental)
 * @author Thomas Obernosterer
 */
@klib.annotations.Experimental
class LClass(
    private val sourceClass: Class<*>
) {
    /**
     * Get a function from the Host class
     *
     * @param functionName The function to load
     * @return A LFunction
     *
     * @see LFunction
     *
     * @since 1.3.0 (Experimental)
     * @author Thomas Obernosterer
     */
    fun getMethod(functionName: String): LFunction {
        val method = sourceClass.getMethod(functionName)
        val classObject = sourceClass.newInstance()
        return LFunction(classObject, method)
    }
}