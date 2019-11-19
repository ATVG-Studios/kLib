package klib.text

/**
 *  Simple StringBuilder DSL-wrapper
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
class KString {
    private val stringBuilder = StringBuilder()

    val length = stringBuilder.length

    /**
     * Append Line to Builder
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun line(value: String) {
        stringBuilder.appendln(value)
    }

    /**
     * Append Text to Builder
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    fun text(value: String) {
        stringBuilder.append(value)
    }

    /**
     * Append Text to Builder
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    operator fun plus(value: String) {
        stringBuilder.append(value)
    }

    /**
     * Append Text to Builder
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    operator fun String.unaryPlus() {
        stringBuilder.append(this)
    }

    /**
     * Append Text to Builder
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    operator fun plusAssign(value: String) {
        stringBuilder.append(value)
    }

    /**
     * Append Text to Builder
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    operator fun plus(value: Char) {
        stringBuilder.append(value)
    }

    /**
     * Append Text to Builder
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    operator fun Char.unaryPlus() {
        stringBuilder.append(this)
    }

    /**
     * Append Text to Builder
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    operator fun plusAssign(value: Char) {
        stringBuilder.append(value)
    }

    /**
     * Get the Builder's Data
     *
     * @return Build string
     *
     * @since 4.0.0
     * @author Thomas Obernosterer
     */
    override fun toString(): String {
        return stringBuilder.toString()
    }
}