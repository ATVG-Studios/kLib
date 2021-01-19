package klib.influx

import klib.extensions.toSimpleString
import java.io.Serializable

/**
 * InfluxData simple data class with toString to create a Influx v2 Measurement Line (for line api)
 *
 * @since 5.2.0
 * @author Thomas Obernosterer
 */
data class InfluxData(val measurement: String, val tags: Map<String, Any>, val fields: Map<String, Any>, val timestamp: String):
    Serializable {
    override fun toString(): String {
        return "$measurement,${tags.toSimpleString()} ${fields.toSimpleString()} $timestamp"
    }
}