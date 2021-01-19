package klib.influx

/**
 *  Influx helper
 *
 *  Object with helpers to use Influx Data
 *  Contains: Influx v2 line Parser
 *
 * @since 5.2.0
 * @author Thomas Obernosterer
 */
object Influx {
    fun parseLine(data: String): InfluxData {
        val parts = data.split(" ")
        val leftParts = parts[0].split(",")
        val midParts = parts[1].split(",")

        val measurement = leftParts[0]
        val tagsList = leftParts.subList(1, leftParts.size)
        val timestamp = parts[parts.size - 1]

        val tags = tagsList.map {
            val tagParts = it.trim().split("=")
            tagParts[0] to tagParts[1]
        }.toMap()

        val fields = midParts.map {
            val fieldParts = it.trim().split("=")
            fieldParts[0] to fieldParts[1]
        }.toMap()

        return InfluxData(measurement, tags, fields, timestamp)
    }
}
