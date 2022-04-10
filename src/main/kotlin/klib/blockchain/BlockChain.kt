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

import klib.extensions.times
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

/**
 * Simple Blockhain that contains many BaseBlock<T>
 *
 * @since 6.0.0
 * @author Thomas Obernosterer
 */
class BlockChain<T> {
    private val blockList: MutableList<BaseBlock<T>> = mutableListOf()

    /**
     * Get all Block from the Chain
     *
     * @since 6.0.0
     * @author Thomas Obernosterer
     */
    val blocks: List<BaseBlock<T>>
        get() = blockList

    /**
     * Get block by Index
     *
     * @since 6.0.0
     * @author Thomas Obernosterer
     */
    operator fun get(index: Int) = blockList[index]

    /**
     * Get block by Hash
     *
     * @since 6.0.0
     * @author Thomas Obernosterer
     */
    operator fun get(hash: String) = blockList.first { it.hash == hash }

    /**
     * Create a new Block with the given Data
     *
     * @return The new Block with index, data, previous_hash and hash
     *
     * @since 6.0.0
     * @author Thomas Obernosterer
     */
    fun newBlock(data: T): BaseBlock<T> {
        val block = if (blockList.size >= 1) {
            BaseBlock(blockList.size, data, blockList[blockList.size - 1].hash)
        } else {
            BaseBlock(0, data, "0" times 64)
        }
        blockList.add(block)
        return block
    }

    /**
     * WriteToStream writes the count of blocks as Integer followed by each block as Object
     *
     * @return Count of objects written including count
     *
     * @since 6.0.0
     * @author Thomas Obernosterer
     */
    fun writeToStream(stream: ObjectOutputStream): Int {
        stream.write(blockList.size)
        blockList.forEach {
            stream.writeObject(it)
        }
        // Return the amount of objects written
        return blockList.size + 1 // +1 as we wrote the size at the beginning
    }

    /**
     * ReadFromStream reads the count of blocks followed by each block
     *
     * @return Count of objects read including count
     *
     * @since 6.0.0
     * @author Thomas Obernosterer
     */
    fun readFromStream(stream: ObjectInputStream): Int {
        val originalCount = blockList.size
        val count = stream.readInt()
        if (count >= 1) {
            var i = count
            while (i > 0) {
                val obj = stream.readObject()
                try {
                    if (obj is BaseBlock<*>) {
                        @Suppress("UNCHECKED_CAST")
                        blockList += obj as BaseBlock<T>
                    }
                } catch (e: Exception) {
                    // Ignore cast failure exceptions
                }
                i--
            }
        }
        // Return the amount of objects we read
        return (blockList.size - originalCount) + 1 // +1 as we read the size at the beginning
    }
}
