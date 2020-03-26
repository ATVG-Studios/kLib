package devtests

import java.io.File
import klib.functions.using

fun main() {
    using(File("").inputStream()) {
    }
}
