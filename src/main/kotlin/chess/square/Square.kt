package chess.square

import chess.Color

data class Square(
    private val column: Column,
    private val row: Row
) {
    private val color: Color = setColor()

    fun getColumn(): Column = this.column
    fun getColor(): Color = this.color

    fun `is`(square: Square): Boolean = this.column == square.column && this.row == square.row
    fun isRowIndex(index: Int): Boolean = this.row.ordinal == index

    private fun setColor(): Color = when {
        columnIsPair() && rowIsPair() -> Color.BLACK
        !columnIsPair() && !rowIsPair() -> Color.BLACK
        else -> Color.WHITE
    }

    private fun columnIsPair(): Boolean {
        return column.ordinal % 2 != 0
    }

    private fun rowIsPair(): Boolean {
        return row.ordinal % 2 != 0
    }

    fun move(horizontal: Int, vertical: Int): Square = Square(column.move(horizontal), row.move(vertical))
    fun differenceColRow(destination: Square): Pair<Int, Int> =
        Pair(destination.column.ordinal - column.ordinal, destination.row.ordinal - row.ordinal)

    fun canMoveUp(): Boolean = row.canMoveUp()
    fun canMoveRight(): Boolean = column.canMoveRight()
    fun canMoveDown(): Boolean = row.canMoveDown()
    fun canMoveLeft(): Boolean = column.canMoveLeft()

    fun maxUpMovement(): Int = row.maxUpMovement()
    fun maxRightMovement(): Int = column.maxRightMovement()
    fun maxDownMovement(): Int = row.maxDownMovement()
    fun maxLeftMovement(): Int = column.maxLeftMovement()

    override fun toString(): String {
        return "${this.column}-${this.row.ordinal + 1}"
    }
}