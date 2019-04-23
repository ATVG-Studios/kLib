package com.atvgstudios.klib.interfaces

import com.atvgstudios.klib.types.hash.HashResult
import java.security.MessageDigest

interface Hasher {
    fun hash(data: ByteArray, algo: String): HashResult {
        val md = MessageDigest.getInstance(algo)
        val digest = md.digest(data)
        return HashResult(hex = digest.fold("") { str, it -> str + "%02x".format(it) }, algo = algo)
    }
}