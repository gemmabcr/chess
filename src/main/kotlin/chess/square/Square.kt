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

    private fun columnIsPair(): Boolean {
        return column.ordinal % 2 != 0
    }

    private fun rowIsPair(): Boolean {
        return row.ordinal % 2 != 0
    }

    fun move(horizontal: Int, vertical: Int): Square = Square(column.move(horizontal), row.move(vertical))

    fun differenceColRow(destination: Square): Pair<Int, Int> =
        Pair(destination.column.ordinal - column.ordinal, destination.row.ordinal - row.ordinal)

    fun canMoveForward(): Boolean = row.canMoveForward()
    fun canMoveRight(): Boolean = column.canMoveRight()
    fun canMoveBackward(): Boolean = row.canMoveBackward()
    fun canMoveLeft(): Boolean = column.canMoveLeft()

    fun maxForwardMovement(): Int = row.maxForwardMovement()
    fun maxRightMovement(): Int = column.maxRightMovement()
    fun maxBackwardMovement(): Int = row.maxBackwardMovement()
    fun maxLeftMovement(): Int = column.maxLeftMovement()

    override fun toString(): String {
        return "${this.column}-${this.row.ordinal + 1}"
    }

    fun maxForwardRightMovement(): Int {
        val maxForwardMovement = maxForwardMovement()
        val maxRightMovement = maxRightMovement()
        return lowerValue(maxForwardMovement, maxRightMovement)
    }

    fun maxForwardLeftMovement(): Int {
        val maxForwardMovement = maxForwardMovement()
        val maxLeftMovement = maxLeftMovement()
        return lowerValue(maxForwardMovement, maxLeftMovement)
    }

    fun maxBackwardRightMovement(): Int {
        val maxBackwardMovement = maxBackwardMovement()
        val maxRightMovement = maxRightMovement()
        return lowerValue(maxBackwardMovement, maxRightMovement)
    }

    fun maxBackwardLeftMovement(): Int {
        val maxBackwardMovement = maxBackwardMovement()
        val maxLeftMovement = maxLeftMovement()
        return lowerValue(maxBackwardMovement, maxLeftMovement)
    }

    private fun lowerValue(firstValue: Int, lastValue: Int) =
        if (firstValue > lastValue) {
            lastValue
        } else firstValue
}