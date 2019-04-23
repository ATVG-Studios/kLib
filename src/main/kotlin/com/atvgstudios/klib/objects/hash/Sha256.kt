package com.atvgstudios.klib.objects.hash

import com.atvgstudios.klib.interfaces.Hasher
import com.atvgstudios.klib.types.hash.HashResult
import java.nio.charset.Charset

object Sha256 : Hasher {
    var defaultCharset: Charset = Charset.defaultCharset()
    fun hash(data: ByteArray): HashResult = super.hash(data, "SHA-256")
    fun hash(data: String): HashResult = super.hash(data.toByteArray(defaultCharset), "SHA-256")
}