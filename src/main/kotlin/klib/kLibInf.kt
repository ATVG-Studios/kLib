package klib

import klib.dummy.JsonHandler
import klib.extensions.toStrInt
import klib.interfaces.Json
import klib.types.SemVer

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
    const val name = "kLib"

    /**
     * Unique Version ID (Used to identify versions; Not for humans)
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    const val versionId = 16 // A unique version number used to identify releases and to make easy requirement checks

    /**
     * Version String (For humans; SemVer)
     *
     * @since 0.1.0
     * @author Thomas Obernosterer
     */
    const val version = "1.5.0"

    /**
     * Version String (For computers; SemVer)
     *
     * @since 2.0.0
     * @author Thomas Obernosterer
     */
    val semver = SemVer(version[0].toStrInt(), version[2].toStrInt(), version[4].toStrInt(), buildMetadata = "$versionId")

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
        "Thomas Obernosterer <thomas.obernosterer@atvg-studios.com> (ATVG-Studios, https://atvg-studios.com)",
        "Nils Rider <night.rider@atvg-studios.at> (ATVG-Studios, https://atvg-studios.com)"
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

    /**
     * Json Handler to be used for Parsing JSON inside kLib
     *
     * @see Json
     *
     * @since 0.1.5
     * @author Thomas Obernosterer
     */
    var jsonHandler: Json = JsonHandler()
}
