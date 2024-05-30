package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Square

class Bishop(
    val color: Color,
    val square: Square
): Piece(color, square) {

    override fun mainMove(): MainMovement = possibleDiagonalMoves()

    override fun journey(destination: Square): List<Square> {
        val moves = square.differenceColRow(destination)

        val differenceCol = moves.first
        val differenceRow = moves.second

        val movesList: MutableList<Square> = mutableListOf()
        for (i in 1 .. getMaxFor(differenceCol)) {
            movesList.add(
                square.move(
                    getIndex(differenceCol, i),
                    getIndex(differenceRow, i)
                )
            )
        }
        return movesList.toList()
    }

    private fun getMaxFor(differenceCol: Int): Int = when {
        differenceCol < 0 -> -differenceCol
        else -> differenceCol
    }

    private fun getIndex(difference: Int, index: Int): Int = when {
        difference < 0 -> -index
        else -> index
    }
}
