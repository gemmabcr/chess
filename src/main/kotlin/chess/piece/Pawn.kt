package chess.piece

import chess.Color
import chess.square.Square

class Pawn(
    private val color: Color,
    private val square: Square
): Piece(color, square) {
    override fun mainMove(): List<Square> = when {
        square.canMoveUp() -> listOf(square.move(0,1))
        else -> emptyList()
    }
    override fun journey(destination: Square): List<Square> = emptyList()
}
