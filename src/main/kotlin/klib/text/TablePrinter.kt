package klib.text

import klib.extensions.times
import java.io.PrintStream

/**
 * Table Printer
 *
 * Table building DSL and a Print function to print it to a PrintStream with System.out as default
 *
 * @param tHeader Table Header (Column Titles)
 * @param tBody List of Rows
 *
 * @since 5.3.0
 * @author Thomas Obernosterer
 */
class TablePrinter(var tHeader: TableHeader = TableHeader(), var tBody: TableBody = TableBody()) {
    /**
     * DSL Class for Table Headers
     *
     * @since 5.3.0
     * @author Thomas Obernosterer
     */
    class TableHeader(var columns: MutableList<String> = mutableListOf()) {
        /**
         * Append Column to table header
         *
         * @param name Name of Column
         *
         * @since 5.3.0
         * @author Thomas Obernosterer
         */
        fun column(name: String) {
            columns.add(name)
        }
    }

    /**
     * DSL Class for Table Body
     *
     * @since 5.3.0
     * @author Thomas Obernosterer
     */
    class TableBody(var rows: MutableList<TableRow> = mutableListOf()) {
        /**
         * Append Row to table body
         *
         * @param value DSL Constructor for TableRow
         *
         * @since 5.3.0
         * @author Thomas Obernosterer
         */
        fun row(value: TableRow.() -> Unit) {
            rows.add(TableRow().apply(value))
        }
    }

    /**
     * DSL Class for Table Rows
     *
     * @param data List of column data in the row
     *
     * @since 5.3.0
     * @author Thomas Obernosterer
     */
    class TableRow(var data: MutableList<Any> = mutableListOf()) {
        /**
         * Append Row column data
         *
         * @param value Column data
         *
         * @since 5.3.0
         * @author Thomas Obernosterer
         */
        fun add(value: Any) {
            data.add(value)
        }
    }

    /**
     * Header Creator
     *
     * @param tableHeader DSL Constructor for TableHeader
     * @return instance of TableHeader
     *
     * @since 5.3.0
     * @author Thomas Obernosterer
     */
    fun header(tableHeader: TableHeader.() -> Unit): TableHeader {
        tHeader = TableHeader(mutableListOf()).apply(tableHeader)
        return tHeader
    }

    /**
     * Headers Addition
     *
     * @param list List of strings as column titles
     *
     * @since 5.3.0
     * @author Thomas Obernosterer
     */
    fun headers(list: List<String>) {
        tHeader.columns.addAll(list)
    }

    /**
     * Body Creator
     *
     * @param tableBody DSL Constructor for TableBody
     * @return instance of TableBody
     *
     * @since 5.3.0
     * @author Thomas Obernosterer
     */
    fun body(tableBody: TableBody.() -> Unit): TableBody {
        tBody = TableBody().apply(tableBody)
        return tBody
    }

    /**
     * Prints the Table to the PrintStream (Default System.out)
     *
     * @param stream PrintStream to write to
     *
     * @since 5.3.0
     * @author Thomas Obernosterer
     */
    fun print(stream: PrintStream = System.out) {
        val columnSize: MutableMap<String, Int> = mutableMapOf()

        // Loop over everything we know to find the biggest column width
        for (cIndex in 0 until tHeader.columns.size) {
            val colName = tHeader.columns[cIndex]

            columnSize[colName] = colName.length

            for (row in tBody.rows) {
                for (rIndex in 0 until row.data.size) {
                    val data = row.data[cIndex].toString()
                    columnSize[colName] = if (columnSize[colName]!! > data.length) (columnSize[colName] ?: colName.length) else data.length
                }
            }
        }

        // Print out Table Header
        // Loop over all columns and print the column name with padding
        for (cIndex in 0 until tHeader.columns.size) {
            val colName = tHeader.columns[cIndex]
            val colSize = columnSize[colName]?.minus(colName.length) ?: colName.length
            stream.print(colName + " ".times(colSize) + "\t")
        }

        // Break line after header end
        stream.print("\n")

        // Print out Table Body
        for (row in tBody.rows) {
            // Loop over all columns and print the data with padding
            for (cIndex in 0 until row.data.size) {
                val colName = tHeader.columns[cIndex]
                val data = row.data[cIndex].toString()
                val colSize = columnSize[colName]?.minus(data.length) ?: data.length

                stream.print(data + " ".times(colSize) + "\t")
            }
            // Break line after row end
            stream.print("\n")
        }
    }
}

/**
 * Table Building DSL
 *
 * Entry into building a Table using the DSL
 *
 * @param tablePrinter DSL Constructor for TablePrinter object
 * @return instance of TablePrinter
 *
 * @since 5.3.0
 * @author Thomas Obernosterer
 */
fun table(tablePrinter: TablePrinter.() -> Unit): TablePrinter {
    return TablePrinter().apply(tablePrinter)
}
