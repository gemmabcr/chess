package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Square

class Rook(
    color: Color,
    private val square: Square
): Piece(color, square) {
    override fun mainMove(): MainMovement = possibleRankFileMoves()

    override fun journey(destination: Square): List<Square> {
        val moves = square.differenceColRow(destination)

        val differenceCol = moves.first
        val differenceRow = moves.second

        val movesList: MutableList<Square> = mutableListOf()
        for (i in 1 .. getMaxFor(differenceCol, differenceRow)) {
            movesList.add(
                square.move(
                    getIndex(differenceCol, i),
                    getIndex(differenceRow, i)
                )
            )
        }
        return movesList.toList()
    }

    private fun getMaxFor(differenceCol: Int, differenceRow: Int): Int = when {
        differenceCol == 0 -> differenceRow
        else -> differenceCol
    }

    private fun getIndex(difference: Int, index: Int): Int = when {
        difference < 0 -> -index
        else -> index
    }
}
