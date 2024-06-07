package chess.square

import kotlin.math.abs

class Journey(
    private val journey: Pair<Square, Square>
) {
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

    private fun getDifferenceRow() = journey.second.getRow().ordinal - journey.first.getRow().ordinal

    private fun getDifferenceCol() = journey.second.getColumn().ordinal - journey.first.getColumn().ordinal

    fun squaresBetween(): Int {
        val direction: Direction = direction()
        return when (direction) {
            Direction.FORWARD -> abs(getDifferenceRow()) - 1
            Direction.BACKWARD -> abs(getDifferenceRow()) - 1
            else -> abs(getDifferenceCol()) - 1
        }
    }
}