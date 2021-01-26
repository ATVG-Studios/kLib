package klib.parser.influx

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
    /**
     * Ingest a Influx Line Protocol line and returns a InfluxData Object
     *
     * @param data A single line of Influx Line Protocol
     * @return InflixData Object
     *
     * @since 5.2.0
     * @author Thomas Obernosterer
     */
    fun parseLine(data: String): InfluxData {
        val parts = data.split(" ")
        val leftParts = parts[0].split(",")
        val midParts = parts[1].split(",")

        val measurement = leftParts[0]
        val tagsList = leftParts.subList(1, leftParts.size)
        val timestamp = parts[parts.size - 1]

        return createInfluxDataFromRawSets(tagsList, midParts, measurement, timestamp)
    }

    /**
     * Ingest a custom Influx Line Protocol line that uses Semicolon to separate measurement; tags; fields; timestamp
     *  and returns a InfluxData Object
     *
     * @param data A single line of Influx Line Protocol
     * @return InflixData Object
     *
     * @since 5.2.0
     * @author Thomas Obernosterer
     */
    fun parseCustomkLibLine(data: String): InfluxData {
        val parts = data.split(";")
        val measurement = parts[0]
        val tagsList = parts[1].split(",")
        val fieldsList = parts[2].split(",")
        val timestamp = parts[3]

        return createInfluxDataFromRawSets(tagsList, fieldsList, measurement, timestamp)
    }

    private fun createInfluxDataFromRawSets(
        tagsList: List<String>,
        fieldsList: List<String>,
        measurement: String,
        timestamp: String
    ): InfluxData {
        val tags = tagsList.map {
            val tagParts = it.trim().split("=")
            tagParts[0] to tagParts[1]
        }.toMap()

        val fields = fieldsList.map {
            val fieldParts = it.trim().split("=")
            fieldParts[0] to fieldParts[1]
        }.toMap()

        return InfluxData(measurement, tags, fields, timestamp)
    }
}
