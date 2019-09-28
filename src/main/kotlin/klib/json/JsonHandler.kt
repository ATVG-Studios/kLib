package klib.json

import com.google.gson.Gson
import java.lang.reflect.Type

/**
 * JsonHandler
 *
 * @since 3.2.0
 * @author Thomas Obernosterer
 */
class JsonHandler : Json {
    /**
     * Convert a Object to a JSON String
     *
     * @param data The Object to convert
     * @return string The JSON String
     *
     * @since 3.2.0
     * @author Thomas Obernosterer
     */
    override fun fromObject(data: Any): String {
        return Gson().toJson(data)
    }

    /**
     * Convert a JSON String to a Object
     *
     * @param data The JSON String
     * @param type The target Type
     * @return Any The Object
     *
     * @since 3.2.0
     * @author Thomas Obernosterer
     */
    override fun toObject(data: String, type: Type): Any? {
        return Gson().fromJson(data, type)
    }
}