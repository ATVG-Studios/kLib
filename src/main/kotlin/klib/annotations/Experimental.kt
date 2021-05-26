/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.annotations

/**
 * Experimental Annotation for Experimental Public API Interfaces
 *
 * @since 0.1.5
 * @since 5.0.0 (Use RequiresOptIn)
 * @author Nils Rider
 */
@Target(AnnotationTarget.CLASS)
@RequiresOptIn("Experimental API that can change at any time", level = RequiresOptIn.Level.WARNING)
annotation class Experimental
