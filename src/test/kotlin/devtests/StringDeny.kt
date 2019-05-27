package devtests

import klib.extensions.deny
import klib.objects.uuid.UniqueID

fun main() {
    UniqueID.random deny ""
}