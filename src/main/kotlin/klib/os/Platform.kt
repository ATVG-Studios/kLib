/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.os

import java.security.AccessController
import java.security.PrivilegedAction

/**
 * Simple accessor to OS Information
 *
 * @since 5.1.0
 * @author Thomas Obernosterer
 */
object Platform {
    private val os = System.getProperty("os.name")
    private val javaFxPlatform = AccessController.doPrivileged(
        PrivilegedAction {
            System.getProperty(
                "javafx.platform"
            )
        } as PrivilegedAction<String>
    )

    /**
     * Check if the current OS is Android
     *
     * @since 5.1.0
     * @author Thomas Obernosterer
     */
    val IsAndroid = javaFxPlatform == "android" || System.getProperty("java.vm.name") == "Dalvik"

    /**
     * Check if the current OS is Windows
     *
     * @since 5.1.0
     * @author Thomas Obernosterer
     */
    val IsWindows = os.startsWith("Windows")

    /**
     * Check if the current OS is macOS
     *
     * @since 5.1.0
     * @author Thomas Obernosterer
     */
    val IsMac = os.startsWith("Mac")

    /**
     * Check if the current OS is Linux but not Android
     *
     * @since 5.1.0
     * @author Thomas Obernosterer
     */
    val IsLinux = os.startsWith("Linux") && !IsAndroid

    /**
     * Check if the current OS is Solaris
     *
     * @since 5.1.0
     * @author Thomas Obernosterer
     */
    val IsSolaris = os.startsWith("SunOS")

    /**
     * Check if the current OS is iOS
     *
     * @since 5.1.0
     * @author Thomas Obernosterer
     */
    val IsiOS = os.startsWith("iOS")
}
