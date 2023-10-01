package chess.square

import chess.Color

class Square(
    private val column: Column,
    private val row: Row
) {
    private val color: Color = setColor()

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

    fun add(columnMove: Int, rowMove: Int): Square = Square(column.add(columnMove), row.add(rowMove))

    fun canMoveUp(): Boolean = row.canMoveUp()
    fun canMoveRight(): Boolean = column.canMoveRight()
    fun canMoveDown(): Boolean = row.canMoveDown()
    fun canMoveLeft(): Boolean = column.canMoveLeft()

    fun maxUpMovement(): Int = row.maxUpMovement()
    fun maxRightMovement(): Int = column.maxRightMovement()
    fun maxDownMovement(): Int = row.maxDownMovement()
    fun maxLeftMovement(): Int = column.maxLeftMovement()
}