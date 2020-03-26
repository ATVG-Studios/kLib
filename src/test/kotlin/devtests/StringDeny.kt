package devtests

import klib.extensions.deny
import klib.uuid.UniqueID

fun main() {
    UniqueID.random deny ""
}
