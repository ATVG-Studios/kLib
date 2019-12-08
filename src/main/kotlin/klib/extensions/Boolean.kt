package klib.extensions

/**
 * Transform Boolean to Integer
 *
 * @return 1 if True, 0 if False
 *
 * @since 1.0.0
 * @author Thomas Obernosterer
 */
fun Boolean.asInt(): Int {
    return if (this) 1 else 0
}
