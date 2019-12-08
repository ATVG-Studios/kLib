package klib.functions

/**
 * Run code with Boolean return status inside Try-Catch
 *
 * @param block
 * @return
 *
 * @since 0.1.0
 * @author Thomas Obernosterer
 */
fun exceptionHandled(block: () -> Boolean): Boolean {
    return try {
        block()
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}

/**
 * Run code with T return inside Try-Catch
 *
 * @param block Code to execute in Try-Catch
 * @return Instance of T
 *
 * @since 0.1.6
 * @author Thomas Obernosterer
 */
inline fun <T> eHandled(block: () -> T) = try { block() } catch (e: Throwable) { e.printStackTrace() }
