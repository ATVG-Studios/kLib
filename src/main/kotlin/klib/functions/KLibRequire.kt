package klib.functions

import klib.kLibInf
import klib.types.SemVer

/**
 * Check if the used kLib is the required version (Dependency Check)
 * If not, kLibInf.exit() is called
 *
 * @param version
 * @see kLibInf.exit
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
fun kLibRequire(version: Int) {
    if (kLibInf.versionId != version) {
        println("This application requires kLib release $version! (Release ${kLibInf.versionId} not Compatible)")
        kLibInf.exit(1)
    }
}

/**
 * Check if the used kLib is the required version (Dependency Check)
 * If not, kLibInf.exit() is called
 *
 * @param version
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
 * Check if the used kLib is in the required version range (Dependency Check)
 * If not, kLibInf.exit() is called
 *
 * @param minVersion
 * @param maxVersion
 * @see kLibInf.exit
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
fun kLibRequire(minVersion: Int, maxVersion: Int) {
    if (kLibInf.versionId < minVersion || kLibInf.versionId > maxVersion) {
        println("This application requires at least kLib release $minVersion and at most kLib release $maxVersion! (Release ${kLibInf.versionId} not Compatible)")
        kLibInf.exit(1)
    }
}