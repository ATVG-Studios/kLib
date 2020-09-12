package klib.extensions

import klib.os.Platform

/**
 * Check if the current OS is Android
 *
 * @since 5.1.0
 * @author Thomas Obernosterer
 */
val System.isAndroid
    get() = Platform.IsAndroid

/**
 * Check if the current OS is Windows
 *
 * @since 5.1.0
 * @author Thomas Obernosterer
 */
val System.isWindows
    get() = Platform.IsWindows

/**
 * Check if the current OS is macOS
 *
 * @since 5.1.0
 * @author Thomas Obernosterer
 */
val System.isMac
    get() = Platform.IsMac

/**
 * Check if the current OS is Linux but not Android
 *
 * @since 5.1.0
 * @author Thomas Obernosterer
 */
val System.isLinux
    get() = Platform.IsLinux

/**
 * Check if the current OS is Solaris
 *
 * @since 5.1.0
 * @author Thomas Obernosterer
 */
val System.isSolaris
    get() = Platform.IsSolaris

/**
 * Check if the current OS is iOS
 *
 * @since 5.1.0
 * @author Thomas Obernosterer
 */
val System.isiOS
    get() = Platform.IsiOS