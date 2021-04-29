package klib

import klib.json.Json
import klib.json.JsonHandler

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
     * Version String (For computers; SemVer)
     *
     * @since 2.0.0
     * @author Thomas Obernosterer
     */
    val semver: SemVer
        get() {
            val ver = javaClass.`package`.implementationVendor
            return if (ver == null) SemVer(5, 0, 0, "unstable")
            else SemVer.parse(ver)
        }

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
    const val license = "MPL2.0"

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
