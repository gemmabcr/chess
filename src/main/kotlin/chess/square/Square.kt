package chess.square

import chess.Color
import chess.square.direction.Diagonal

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

    fun move(diagonal: Diagonal, index: Int): Square = when {
        diagonal `is` Diagonal.FORWARD_RIGHT -> Square(column.move(index), row.move(index))
        diagonal `is` Diagonal.BACKWARD_RIGHT -> Square(column.move(index), row.move(-index))
        diagonal `is` Diagonal.BACKWARD_LEFT -> Square(column.move(-index), row.move(-index))
        else -> Square(column.move(-index), row.move(index))
    }

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

    fun maxForwardLeftMovement(): Int = lowerValue(maxForwardMovement(), maxLeftMovement())
    fun maxForwardRightMovement(): Int = lowerValue(maxForwardMovement(), maxRightMovement())
    fun maxBackwardLeftMovement(): Int = lowerValue(maxBackwardMovement(), maxLeftMovement())
    fun maxBackwardRightMovement(): Int = lowerValue(maxBackwardMovement(), maxRightMovement())

    private fun lowerValue(firstValue: Int, lastValue: Int) = when {
        firstValue > lastValue -> lastValue
        else -> firstValue
    }

    fun canMoveForwardRight(): Boolean = canMoveForward() && canMoveRight()
    fun canMoveBackwardRight(): Boolean = canMoveBackward() && canMoveRight()
    fun canMoveBackwardLeft(): Boolean = canMoveBackward() && canMoveLeft()
    fun canMoveForwardLeft(): Boolean = canMoveForward() && canMoveLeft()
}