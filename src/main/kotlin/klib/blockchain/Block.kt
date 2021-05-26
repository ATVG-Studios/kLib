/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.blockchain

import klib.extensions.ul

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
    nonce: ULong = 0L.ul,
    data: String,
    prevBlock: String
) : BaseBlock<String>(id, nonce, data, prevBlock)
