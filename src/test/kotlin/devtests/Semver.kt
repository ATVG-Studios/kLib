package devtests

import klib.types.SemVer

fun main() {
    val semver1 = SemVer.parse("1.0.0")
    println(semver1)

    val semver2 = SemVer.parse("1.0.0-beta")
    println(semver2)

    val semver3 = SemVer.parse("1.0.0-beta+4")
    println(semver3)
}