package devtests

import klib.Konfig

fun main() {
    val testKonfig = """
        test=["I","need","HELP!"]
        help=false
        map={a:0,b:102}
    """.trimIndent()

    println(Konfig.parseString(testKonfig))

    if ((Konfig.parseString(testKonfig)["help"] as Boolean)) {
        println("Help was True")
    }
}
