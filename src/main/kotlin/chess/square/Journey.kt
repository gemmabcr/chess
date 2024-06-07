package chess.square

import kotlin.math.abs

class Journey(
    private val journey: Pair<Square, Square>
) {
    fun origin(): Square = journey.first

    fun destination(): Square = journey.second

    fun direction(): Direction {
        val differenceCol = getDifferenceCol()
        val differenceRow = getDifferenceRow()

        if (differenceCol == 0) {
            if (differenceRow > 0) {
                return Direction.FORWARD
            }
            return Direction.BACKWARD
        }

        if (differenceRow == 0) {
            if (differenceCol > 0) {
                return Direction.RIGHT
            }
            return Direction.LEFT
        }

        if (differenceRow < 0) {
            if (differenceCol < 0) {
                return Direction.BACKWARD_LEFT
            }
            return Direction.BACKWARD_RIGHT
        }

        if (differenceCol < 0) {
            return Direction.FORWARD_LEFT
        }
        return Direction.FORWARD_RIGHT
    }

    private fun getDifferenceRow() = destination().getRow().ordinal - origin().getRow().ordinal

    private fun getDifferenceCol() = destination().getColumn().ordinal - origin().getColumn().ordinal

    fun squaresBetweenTotal(): Int {
        val direction: Direction = direction()
        return when (direction) {
            Direction.FORWARD -> abs(getDifferenceRow()) - 1
            Direction.BACKWARD -> abs(getDifferenceRow()) - 1
            else -> abs(getDifferenceCol()) - 1
        }
    }

    fun squaresBetween(): List<Square> {
        val direction: Direction = direction()
        val total: Int = squaresBetweenTotal()
        val squares = mutableListOf<Square>()
        for (i in 1..total) {
            squares.add(origin().move(direction, i))
        }
        return squares
    }
}