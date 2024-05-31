package chess.piece

import chess.Color
import chess.square.Direction
import chess.square.Square

class King(
    color: Color,
    val square: Square
) : Piece(color, square, 1) {
    override fun directions(): List<Direction> = Direction.all()

    override fun journey(destination: Square): List<Square> = emptyList()

    override fun isKing(): Boolean = true
}
