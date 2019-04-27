package com.atvgstudios.klib.functions

import com.atvgstudios.klib.kLibInf

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
        println("This application requires kLib $version! (Version ${kLibInf.versionId} not Compatible)")
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
        println("This application requires at least kLib $minVersion and at most kLib $maxVersion! (Version ${kLibInf.versionId} not Compatible)")
        kLibInf.exit(1)
    }
}