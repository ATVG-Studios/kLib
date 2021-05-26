/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

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
