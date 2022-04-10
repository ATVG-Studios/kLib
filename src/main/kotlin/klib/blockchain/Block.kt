/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2022 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2022 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.blockchain

/**
 * Simple Block that can be chained
 *
 * @see BaseBlock
 *
 * @since 6.0.0
 * @author Thomas Obernosterer
 */
class Block(
    id: Int,
    data: String,
    prevBlock: String
) : BaseBlock<String>(id, data, prevBlock)
