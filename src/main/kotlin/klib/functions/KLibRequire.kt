package klib.functions

import klib.kLibInf
import klib.types.SemVer

/**
 * Check if the used kLib is the required version (Dependency Check)
 * If not, kLibInf.exit() is called
 *
 * @param version Required Version
 * @see kLibInf.exit
 *
 * @since 2.1.0
 * @author Thomas Obernosterer
 */
fun kLibRequire(version: SemVer) {
    if (kLibInf.semver < version) {
        println("This application requires kLib $version! (Version ${kLibInf.semver} not Compatible)")
        kLibInf.exit(1)
    }
}

/**
 * Check if the used kLib is the required version (Dependency Check)
 * If not, kLibInf.exit() is called
 *
 * @param min Minimum Version
 * @param max Maximum Version
 * @see kLibInf.exit
 *
 * @since 3.0.0
 * @author Thomas Obernosterer
 */
fun kLibRequire(min: SemVer, max: SemVer) {
    if (kLibInf.semver < min || kLibInf.semver > max) {
        println("This application requires kLib a version between $min and $max! (Version ${kLibInf.semver} not Compatible)")
        kLibInf.exit(1)
    }
}