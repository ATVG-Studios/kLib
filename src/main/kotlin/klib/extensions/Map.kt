package klib.extensions

/**
 *  Transforms a Map of <K, V> into a key=value comma separated list
 *
 *  K and V must provide a toString function that only returns a simple string
 *
 * @since 5.2.0
 * @author Thomas Obernosterer
 */
fun Map<*,*>.toSimpleString(): String = this.map { "${it.key.toString().normalize()}=${it.value.toString().normalize()}" }.joinToString(",")