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
import org.junit.Test
import kotlin.test.assertEquals

class BlockTest {

    @Test
    fun `Mine a block twice and get the expected Hash and Nonce both times`() {
        // Create a block and mine it
        val block = Block(1, 0L.ul, "hello to my first block", "0000000000000000000000000000000000000000000000000000000000000000")
        val minedBlock = block.mine()
        // Verify the mining worked
        assertEquals("000095c0a80045786c359e5414fd52456cf0a2bbd78860d454f366e9f982b757", minedBlock.hash().lowercase(), "First iteration Mining of Block doesnt result in expected Hash")
        assertEquals(42591L.ul, minedBlock.nonce, "First iteration nonce is not expected 42591 UL")

        // Create a copy of the block
        val newBlock = Block(minedBlock.id, minedBlock.nonce, minedBlock.data, minedBlock.prevBlock)
        val minedAgain = newBlock.mine()
        // Verify the mining still works
        assertEquals("000095c0a80045786c359e5414fd52456cf0a2bbd78860d454f366e9f982b757", minedAgain.hash().lowercase(), "Second iteration Mini of Block doesnt result in expected Hash")
        assertEquals(42591L.ul, minedAgain.nonce, "Second iteration nonce is not expected 42591 UL")
    }
}
