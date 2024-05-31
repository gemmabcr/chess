package chess.piece

import chess.Color
import chess.square.Direction
import chess.square.Square

class Queen(
    color: Color,
    val square: Square
) : Piece(color, square) {
    override fun directions(): List<Direction> = Direction.all()

    override fun journey(destination: Square): List<Square> {
        TODO("Not yet implemented")
    }
}
