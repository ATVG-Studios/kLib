package klib

import klib.exceptions.InvalidTypeException
import klib.extensions.isNumeric

/**
 * SemVer implementation
 *
 * @param major Major Version
 * @param minor Minor Version
 * @param patch Patch Level
 * @param preRelease Pre-Release info
 * @param buildMetadata Build Data
 *
 * @source This feature was inspired by SemVer 1.1.1 from Swiftzer (http://swiftzer.net/)
 *
 * @since 2.0.0
 * @author Thomas Obernosterer
 */
class SemVer(
    val major: Int = 1,
    val minor: Int = 0,
    val patch: Int = 0,
    val preRelease: String? = null,
    val buildMetadata: String? = null
) {
    /**
     * Check if version is initial development (0.x.x)
     *
     * @since 2.0.0
     * @author Thomas Obernosterer
     */
    val isInitialDevelopment: Boolean = major == 0

    companion object {
        /**
         * Parse a String to a SemVer
         *
         * @param version The String to parse
         * @return a SemVer object
         *
         * @since 2.0.0
         * @author Thomas Obernosterer
         */
        fun parse(version: String): SemVer {
            val pattern = Regex("""(0|[1-9]\d*)?(?:\.)?(0|[1-9]\d*)?(?:\.)?(0|[1-9]\d*)?(?:-([\dA-z\-]+(?:\.[\dA-z\-]+)*))?(?:\+([\dA-z\-]+(?:\.[\dA-z\-]+)*))?""")
            val result = pattern.matchEntire(version) ?: throw InvalidTypeException(version, "SemVer Version String")

            var preRelease: String? = result.groupValues[4]
            var buildMetadata: String? = result.groupValues[5]

            if (preRelease != null && preRelease.isEmpty()) preRelease = null
            if (buildMetadata != null && buildMetadata.isEmpty()) buildMetadata = null

            return SemVer(
                major = result.groupValues[1].toIntOrNull() ?: 0,
                minor = result.groupValues[2].toIntOrNull() ?: 0,
                patch = result.groupValues[3].toIntOrNull() ?: 0,
                preRelease = preRelease,
                buildMetadata = buildMetadata
            )
        }
    }

    /**
     * Default Constructor
     *
     * @since 2.0.0
     * @author Thomas Obernosterer
     */
    init {
        require(major >= 0) { "Major version must be a positive number" }
        require(minor >= 0) { "Minor version must be a positive number" }
        require(patch >= 0) { "Patch version must be a positive number" }
        require(preRelease?.matches(Regex("""[\dA-z\-]+(?:\.[\dA-z\-]+)*""")) ?: true) { "Pre-release version is not valid" }
        require(buildMetadata?.matches(Regex("""[\dA-z\-]+(?:\.[\dA-z\-]+)*""")) ?: true) { "Build metadata is not valid" }
    }

    /**
     * Correctly show version String
     *
     * @since 2.0.0
     * @author Thomas Obernosterer
     */
    override fun toString(): String = buildString {
        append("$major.$minor.$patch")
        if (preRelease != null) {
            append('-')
            append(preRelease)
        }
        if (buildMetadata != null) {
            append('+')
            append(buildMetadata)
        }
    }

    /**
     * Implementation for easy version compare
     *
     * @param other The version to compare with
     * @return Integer (0 on error)
     *
     * @since 2.0.0
     * @author Thomas Obernosterer
     */
    operator fun compareTo(other: SemVer): Int {
        return when {
            major > other.major -> 1
            major < other.major -> -1
            minor > other.minor -> 1
            minor < other.minor -> -1
            patch > other.patch -> 1
            patch < other.patch -> -1
            preRelease.isNullOrEmpty() && other.preRelease.isNullOrEmpty() -> 0
            preRelease!!.isNotEmpty() && other.preRelease.isNullOrEmpty() -> -1
            preRelease.isNullOrEmpty() && other.preRelease!!.isNotEmpty() -> 1
            else -> {
                val parts = preRelease.orEmpty().split(".")
                val otherParts = other.preRelease.orEmpty().split(".")
                val endIndex = Math.min(parts.size, otherParts.size) - 1

                for (i in 0..endIndex) {
                    val part = parts[i]
                    val otherPart = otherParts[i]

                    if (part == otherPart) continue

                    val partIsNumeric = part.isNumeric()
                    val otherPartIsNumeric = otherPart.isNumeric()

                    return when {
                        partIsNumeric && !otherPartIsNumeric -> -1
                        !partIsNumeric && otherPartIsNumeric -> 1
                        !partIsNumeric && !otherPartIsNumeric -> {
                            if (part > otherPart) return 1
                            if (part < otherPart) return -1
                            0
                        }
                        else -> {
                            val partInt = part.toInt()
                            val otherPartInt = otherPart.toInt()

                            if (partInt > otherPartInt) return 1
                            if (partInt < otherPartInt) return -1
                            0
                        }
                    }
                }

                if (parts.size == endIndex + 1 && otherParts.size > endIndex + 1) return -1
                if (parts.size > endIndex + 1 && otherParts.size == endIndex + 1) return 1
                0
            }
        }
    }
}
