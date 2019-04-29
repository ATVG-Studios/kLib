package com.atvgstudios.klib.dummy

import com.atvgstudios.klib.interfaces.Json
import java.lang.reflect.Type

/**
 * Dummy JsonHandler
 *
 * @since 0.1.5
 * @author Nils Rider
 */
class JsonHandler : Json {
    override fun toObject(data: String, type: Any): Any {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun fromObject(data: Any): String {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun toObject(data: String, type: Type): Any? {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}