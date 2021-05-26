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

import org.joda.time.DateTime
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Text Prompt generic
 *
 * Supports Int, Long, BigDecimal, String and Date (see dateFormat parameter)
 *
 * @param text Prompt Text (printed as-given)
 * @param default Default value to return on error or no-value (defaults to null)
 * @param reader Function that reads a nullable string and returns it
 * @param printer Function that writes a string
 * @param dateFormat SimpleDateFormat for date parsing (defautls to yyyy-MM-dd)
 *
 * @return object of T with read value, default or null
 *
 * @since 5.3.0
 * @author Thomas Obernosterer
 */
inline fun <reified T> prompt(
    text: String,
    default: T? = null,
    reader: () -> String? = ::readLine,
    printer: (String) -> Unit = ::print,
    dateFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
): T? {
    try {
        // Print out the Prompt Text
        printer(text)

        // Read from Input
        val input = reader()

        // When nothing read, return default
        if (input == null || input.isEmpty()) {
            return default
        }

        // Try to find out what is asked and return it
        return when (T::class) {
            Date::class -> dateFormat.parse(input) as T?
            DateTime::class -> DateTime.parse(input) as T?
            Int::class -> input.toIntOrNull() as T?
            Long::class -> input.toLongOrNull() as T?
            BigDecimal::class -> input.toBigDecimalOrNull() as T?
            Boolean::class -> {
                if (input.lowercase(Locale.getDefault()) == "y" || input.lowercase(Locale.getDefault()) == "j") {
                    true as T?
                } else if (input.lowercase(Locale.getDefault()) == "n") {
                    false as T?
                } else {
                    null
                }
            }
            String::class -> input as T?
            else -> default
        }
    } catch (e: Exception) {
        // We just catch exceptions during input and parsing so that its not bubbling up to the caller
        // as we get a default value (either a real value or a null value) we can just return that on error
    }

    return default
}
