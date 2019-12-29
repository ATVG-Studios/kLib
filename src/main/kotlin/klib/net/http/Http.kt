package klib.net.http

import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL
import klib.extensions.readText
import klib.kLibInf

/**
 * Simple HTTP Client
 *
 * @param url URL for requests
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
class Http(private val url: String) {
    private fun openConnection(uri: String) = URL(uri).openConnection() as HttpURLConnection

    /**
     * Send get Request
     *
     * @param optionalParams Appended to URL with & if ? already present; else with ?
     * @param headers Map of Headers
     * @return Request Response
     *
     * @since 3.1.0
     * @author Thomas Obernosterer
     */
    fun get(optionalParams: String = "", headers: Map<String, String> = HashMap()): String {
        val uri = "$url${if (url.contains("?")) "&" else "?"}$optionalParams"
        val connection= openConnection(uri)

        connection.doInput = true
        connection.requestMethod = "GET"
        connection.setRequestProperty("User-Agent", "kLib/${kLibInf.semver}")

        if (headers.isNotEmpty()) {
            headers.forEach {
                connection.setRequestProperty(it.key, it.value)
            }
        }

        return connection.inputStream.readText()
    }

    /**
     * Send post Request
     *
     * @param data Data to send
     * @param datatype Content-Type Header
     * @param headers Map of Headers
     * @return Request Response
     *
     * @since 3.1.0
     * @author Thomas Obernosterer
     */
    fun post(data: String, datatype: DataTypes, headers: Map<String, String> = HashMap()): String {
        val connection= openConnection(url)

        connection.doOutput = true
        connection.requestMethod = "POST"
        connection.setRequestProperty("User-Agent", "kLib/${kLibInf.semver}")

        if (headers.isNotEmpty()) {
            headers.forEach {
                connection.setRequestProperty(it.key, it.value)
            }
        }

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
     * Send custom Request
     *
     * @param method HTTP Method
     * @param data Data to send (Empty string if none)
     * @param headers Map of headers
     *
     * @since 3.2.0
     * @author Thomas Obernosterer
     */
    fun custom(method: String = "GET", data: String = "", headers: Map<String, String> = HashMap()): String {
        val connection= openConnection(url)

        if (data.isEmpty()) {
            connection.doInput = true
        } else {
            connection.doOutput = true
        }

        connection.requestMethod = method
        connection.setRequestProperty("User-Agent", "kLib/${kLibInf.semver}")

        if (headers.isNotEmpty()) {
            headers.forEach {
                connection.setRequestProperty(it.key, it.value)
            }
        }

        return if (data.isEmpty()) {
            connection.inputStream.readText()
        } else {
            DataOutputStream(connection.outputStream).writeBytes(data)
            connection.inputStream.readText()
        }
    }

    /**
     * Supported Data Types
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
