package chess.piece

import chess.Color
import chess.square.Square

class King(
    private val color: Color,
    private val square: Square
): Piece(color, square) {
    override fun mainMove(): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()

        possibleDiagonalMoves(1).forEach { square -> possibleMoves.add(square) }
        possibleRankFileMoves(1).forEach { square -> possibleMoves.add(square) }

        return possibleMoves
    }
    override fun journey(destination: Square): List<Square> = emptyList()
}
