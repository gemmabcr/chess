package chess.piece

import chess.Color
import chess.square.Square

class Pawn(
    private val color: Color,
    private val square: Square
) : Piece(color, square) {
    override fun mainMove(): List<Square> {
        val list = mutableListOf<Square>()
        if (square.canMoveUp()) {
            list.add(square.move(0, 1))
            if (square.canMoveLeft()) {
                list.add(square.move(-1, 1))
            }
            if (square.canMoveRight()) {
                list.add(square.move(1, 1))
            }
        }
        return list.sortedBy { it.getColumn() }
    }

    override fun journey(destination: Square): List<Square> = emptyList()
}
