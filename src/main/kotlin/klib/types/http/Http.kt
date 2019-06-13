package klib.types.http

import klib.extensions.readText
import klib.kLibInf
import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL

/**
 * Simple HTTP Client
 *
 * @param url URL for requests
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
class Http(val url: String) {

    /**
     * Send get Request
     *
     * @param optionalParams Appended to URL with & if ? already present; else with ?
     * @return Request Response
     *
     * @since 3.1.0
     * @author Thomas Obernosterer
     */
    fun get(optionalParams: String = ""): String {
        val uri = "$url${if (url.contains("?")) "&" else "?"}$optionalParams"
        val connection = URL(uri).openConnection() as HttpURLConnection

        connection.doInput = true
        connection.requestMethod = "GET"
        connection.setRequestProperty("User-Agent", "kLib/${kLibInf.semver}")

        return connection.inputStream.readText()
    }

    /**
     * Send post Request
     *
     * @param data Data to send
     * @param datatype Content-Type Header
     * @return Request Response
     *
     * @since 3.1.0
     * @author Thomas Obernosterer
     */
    fun post(data: String, datatype: DataTypes): String {
        val connection = URL(url).openConnection() as HttpURLConnection

        connection.doOutput = true
        connection.requestMethod = "POST"
        connection.setRequestProperty("User-Agent", "kLib/${kLibInf.semver}")

        when (datatype) {
            DataTypes.JSON ->
                connection.setRequestProperty("Content-Type", "application/json")
            DataTypes.FORM ->
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
        }

        DataOutputStream(connection.outputStream).writeBytes(data)
        return connection.inputStream.readText()
    }

    /**
     * Supported Datatypes
     */
    enum class DataTypes {
        /**
         * HTML Form data (application/x-www-form-urlencoded)
         */
        FORM,
        /**
         * JSON data (application/json)
         */
        JSON
    }
}