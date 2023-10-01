package chess.piece

import chess.Color
import chess.square.Square

class Bishop(
    private val color: Color,
    private val square: Square
): Piece(color, square) {
    override fun mainMove(): List<Square> = possibleDiagonalMoves()
}
