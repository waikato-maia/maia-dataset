package maia.ml.dataset.view

import maia.ml.dataset.DataColumn
import maia.ml.dataset.DataRow
import maia.ml.dataset.headers.header.DataColumnHeader
import maia.ml.dataset.headers.header.DataColumnHeaderView
import maia.ml.dataset.type.DataRepresentation

/**
 * A read-only view of a single column from a row as
 * a data-column of size one.
 *
 * @param source        The source data-row.
 * @param columnIndex   The column of the row to view.
 */
open class DataRowColumnView<T>(
        protected val source : DataRow,
        protected val representation: DataRepresentation<*, *, T>
) : DataColumn<T> {
    override val header : DataColumnHeader = DataColumnHeaderView(
        representation.dataType.header,
        0
    )

    override val numRows : Int = 1

    override fun getRow(rowIndex : Int) : T = source.getValue(representation)

}

/**
 * TODO
 */
fun <T> DataRow.readOnlyViewColumn(representation: DataRepresentation<*, *, T>) : DataRowColumnView<T> {
    return DataRowColumnView(this, representation)
}
