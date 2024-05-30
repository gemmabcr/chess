package chess.piece

import chess.Color
import chess.square.Square

class Queen(
    private val color: Color,
    private val square: Square
): Piece(color, square) {
    override fun mainMove(): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()

        possibleDiagonalMoves().forEach { square -> possibleMoves.add(square) }
        possibleRankFileMoves().forEach { square -> possibleMoves.add(square) }

        return possibleMoves.sortedBy { it.getColumn() }.toList()
    }
    override fun journey(destination: Square): List<Square> {
        TODO("Not yet implemented")
    }
}
