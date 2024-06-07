package chess.piece

import chess.Color
import chess.square.Direction
import chess.square.Square

class King(
    color: Color,
    square: Square
) : Piece(color, square, Direction.all(), 1) {
    override fun isKing(): Boolean = true
}
