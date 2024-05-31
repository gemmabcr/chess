package chess.piece

import chess.Color
import chess.square.Direction
import chess.square.Square

class Pawn(
    color: Color,
    private val square: Square
) : Piece(color, square, 1) {
    override fun directions(): List<Direction> = Direction.forwards()

    override fun journey(destination: Square): List<Square> = emptyList()
}
