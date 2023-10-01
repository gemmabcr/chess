package chess.piece

import chess.Color
import chess.square.Square

class Rook(
    private val color: Color,
    private val square: Square
): Piece(color, square) {
    override fun mainMove(): List<Square> = possibleRankFileMoves()
    override fun journey(destination: Square): List<Square> {
        TODO("Not yet implemented")
    }
}
