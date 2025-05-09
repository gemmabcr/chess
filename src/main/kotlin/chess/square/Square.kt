package chess.square

import chess.Color

data class Square(
    val column: Column,
    val row: Row,
    val color: Color
) {
    constructor(column: Column, row: Row) : this(column, row, setColor(column, row))

    companion object {
        fun setColor(column: Column, row: Row): Color = when {
            (column.ordinal + row.ordinal) % 2 == 0 -> Color.BLACK
            else -> Color.WHITE
        }
    }

    fun `is`(square: Square): Boolean = this.column == square.column && this.row == square.row

    fun isRowIndex(index: Int): Boolean = this.row.ordinal == index

    fun move(horizontal: Int, vertical: Int): Square = Square(column.move(horizontal), row.move(vertical))

    fun move(direction: Direction, index: Int): Square = when (direction) {
        Direction.FORWARD -> Square(column, row.move(index))
        Direction.LEFT -> Square(column.move(-index), row)
        Direction.BACKWARD -> Square(column, row.move(-index))
        Direction.RIGHT -> Square(column.move(index), row)
        Direction.FORWARD_LEFT -> Square(column.move(-index), row.move(index))
        Direction.BACKWARD_LEFT -> Square(column.move(-index), row.move(-index))
        Direction.BACKWARD_RIGHT -> Square(column.move(index), row.move(-index))
        Direction.FORWARD_RIGHT -> Square(column.move(index), row.move(index))
    }

    override fun toString(): String = "${this.column}-${this.row.ordinal + 1}"
}