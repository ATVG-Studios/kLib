/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.functions

/**
 * Create a Pair of A and B
 *
 * @param first First Pair Element
 * @param second Second Pair Element
 * @return Pair(first, second)
 *
 * @see pairOf
 *
 * @since 1.1.0
 * @author Nils Rider
 */
fun <A, B> p(first: A, second: B) = pairOf(first, second)

/**
 * Create a Pair of A and B
 *
 * @param first First Pair Element
 * @param second Second Pair Element
 * @return Pair(first, second)
 *
 * @since 1.1.0
 * @author Nils Rider
 */
fun <A, B> pairOf(first: A, second: B) = Pair(first, second)
