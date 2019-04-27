package com.atvgstudios.klib

/**
 * kLib Information Center
 *
 * @since 0.1.0
 * @author Thomas Obernosterer
 */
object kLibInf {
    /**
     * Full name of kLib
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    const val name = "ATVG-Studios Kotlin Std Library"

    /**
     * Unique Version ID (Used to identify versions; Not for humans)
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    const val versionId = 4 // A unique version number used to identify releases and to make easy requirement checks

    /**
     * Version String (For humans; SemVer)
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    const val version = "0.1.3"

    /**
     * Company creating kLib
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    const val company = "ATVG-Studios"

    /**
     * License of kLib
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    const val license = "MIT"

    /**
     * List of Authors
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    val authors = arrayListOf(
        // Format: Name <Email> (Company, Homepage)
        "Thomas Obernosterer <thomas.obernosterer@atvg-studios.com> (ATVG-Studios, https://atvg-studios.com)"
    )

    /**
     * By overwriting this, a developer can change what happens when kLib gets in trouble and wants to exit.
     * This is used in kLibRequire to exit the program.
     *
     * @see System.exit
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    var exit: (status: Int) -> Unit = { System.exit(it) }
}