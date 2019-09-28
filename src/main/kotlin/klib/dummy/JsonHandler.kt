package klib.dummy

import klib.json.Json
import java.lang.reflect.Type

/**
 * Dummy JsonHandler
 *
 * @since 0.1.5
 * @since 3.2.0 - Deprecated
 * @deprecated
 * @author Nils Rider
 */
@Deprecated(message = "This was a dummy because no JSON parser was part of kLib. But we now ship with a JSON Parser!", replaceWith = ReplaceWith("klib.json.JsonHandler"), level = DeprecationLevel.ERROR)
class JsonHandler : Json {
    override fun fromObject(data: Any): String {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun toObject(data: String, type: Type): Any? {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}