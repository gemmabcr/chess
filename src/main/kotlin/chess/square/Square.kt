package chess.square

import chess.Color

data class Square(
    private val column: Column,
    private val row: Row
) {
    private val color: Color = setColor()

    fun getColumn(): Column = this.column

    fun getRow(): Row = this.row

    fun getColor(): Color = this.color

    fun `is`(square: Square): Boolean = this.column == square.column && this.row == square.row

    fun isRowIndex(index: Int): Boolean = this.row.ordinal == index

    private fun setColor(): Color = when {
        columnIsPair() && rowIsPair() -> Color.BLACK
        !columnIsPair() && !rowIsPair() -> Color.BLACK
        else -> Color.WHITE
    }

    private fun columnIsPair(): Boolean = column.ordinal % 2 != 0

    private fun rowIsPair(): Boolean = row.ordinal % 2 != 0

    fun move(horizontal: Int, vertical: Int): Square = Square(column.move(horizontal), row.move(vertical))

    fun canMove(direction: Direction): Boolean = when {
        direction `is` Direction.FORWARD -> canMoveForward()
        direction `is` Direction.LEFT -> canMoveLeft()
        direction `is` Direction.BACKWARD -> canMoveBackward()
        direction `is` Direction.RIGHT -> canMoveRight()
        direction `is` Direction.FORWARD_LEFT -> canMoveForward() && canMoveLeft()
        direction `is` Direction.BACKWARD_LEFT -> canMoveBackward() && canMoveLeft()
        direction `is` Direction.BACKWARD_RIGHT -> canMoveBackward() && canMoveRight()
        direction `is` Direction.FORWARD_RIGHT -> canMoveForward() && canMoveRight()
        else -> false
    }

    private fun canMoveForward(): Boolean = row.canMoveForward()
    private fun canMoveRight(): Boolean = column.canMoveRight()
    private fun canMoveBackward(): Boolean = row.canMoveBackward()
    private fun canMoveLeft(): Boolean = column.canMoveLeft()

    fun move(direction: Direction, index: Int): Square = when {
        direction `is` Direction.FORWARD -> Square(column, row.move(index))
        direction `is` Direction.LEFT -> Square(column.move(-index), row)
        direction `is` Direction.BACKWARD -> Square(column, row.move(-index))
        direction `is` Direction.RIGHT -> Square(column.move(index), row)
        direction `is` Direction.FORWARD_LEFT -> Square(column.move(-index), row.move(index))
        direction `is` Direction.BACKWARD_LEFT -> Square(column.move(-index), row.move(-index))
        direction `is` Direction.BACKWARD_RIGHT -> Square(column.move(index), row.move(-index))
        direction `is` Direction.FORWARD_RIGHT -> Square(column.move(index), row.move(index))
        else -> throw Exception("Can't move diagonal with $direction")
    }

    override fun toString(): String {
        return "${this.column}-${this.row.ordinal + 1}"
    }
}