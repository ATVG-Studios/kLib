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

import klib.library.LClass
import klib.library.LFunction
import klib.library.LibLoad
import klib.library.Library
import java.io.FileNotFoundException

/**
 * Dynamically load a Class from a Jar File
 *
 * @param builder LibLoader Builder
 * @return Returns a LClass object
 * @throws FileNotFoundException
 * @throws ClassNotFoundException
 *
 * @see LClass
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
@Throws(FileNotFoundException::class, ClassNotFoundException::class)
fun loadClass(builder: LibLoad.() -> Unit): LClass {
    return Library.loadClassFromJar(LibLoad().apply(builder))
}

/**
 * Dynamically load a Method/Function from a Jar File
 *
 * @param builder LibLoader Builder
 * @return Returns a LFunction object
 * @throws FileNotFoundException
 * @throws ClassNotFoundException
 * @throws NoSuchMethodException
 *
 * @see LClass
 * @see LFunction
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
@Throws(FileNotFoundException::class, ClassNotFoundException::class, NoSuchMethodException::class)
fun loadFunction(builder: LibLoad.() -> Unit): LFunction {
    return Library.loadFunctionFromJar(LibLoad().apply(builder))
}
