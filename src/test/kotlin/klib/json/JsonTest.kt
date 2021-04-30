package klib.json

import klib.kLibInf
import net.jemzart.jsonkraken.JsonObject
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class JsonTest {
    private val dataMap = mapOf(
        "hello" to "world",
        "yes" to "no",
        "hungry" to "eat"
    )
    private val data: JsonObject by lazy {
        val newObj = JsonObject()
        newObj["hello"] = "world"
        newObj["yes"] = "no"
        newObj["hungry"] = "eat"
        newObj
    }
    private val json = "{\"hello\":\"world\",\"yes\":\"no\",\"hungry\":\"eat\"}"

    private val arrData = listOf("Hello", "this", "is", "a", "test")
    private val arrJson = "[\"Hello\",\"this\",\"is\",\"a\",\"test\"]"

    @Test
    fun `Map to JSON`() {
        val newJson = kLibInf.jsonHandler.fromObject(dataMap)

        assertEquals(json, newJson)
    }

    @Test
    fun `JSON to JsonObject`() {
        val newObject = kLibInf.jsonHandler.toObject(json)
        assertNotNull(newObject)

        assert(newObject is JsonObject)
        val jsonObject = newObject as JsonObject

        assertEquals(data["hello"], jsonObject["hello"])
        assertEquals(data["yes"], jsonObject["yes"])
        assertEquals(data["hungry"], jsonObject["hungry"])
    }

    @Test
    fun `Array to JSON`() {
        val newJson = kLibInf.jsonHandler.fromObject(arrData)

        assertEquals(arrJson, newJson)
    }

    @Test
    fun `JSON to Array`() {
        val newArray = kLibInf.jsonHandler.toArray(arrJson)
        assertNotNull(newArray)

        val values = mutableListOf<String>()
        newArray.forEach {
            values.add(it.cast())
        }

        assertEquals(arrData, values.toList())
    }
}
