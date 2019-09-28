package klib

class KString {
    private val stringBuilder = StringBuilder()

    val length = stringBuilder.length

    fun line(value: String) {
        stringBuilder.appendln(value)
    }

    fun text(value: String) {
        stringBuilder.append(value)
    }

    operator fun plus(value: String) {
        stringBuilder.append(value)
    }

    operator fun String.unaryPlus() {
        stringBuilder.append(this)
    }

    operator fun plusAssign(value: String) {
        stringBuilder.append(value)
    }

    override fun toString(): String {
        return stringBuilder.toString()
    }
}