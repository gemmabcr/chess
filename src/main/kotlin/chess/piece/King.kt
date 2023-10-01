package chess.piece

import chess.Color
import chess.square.Square

class King(
    private val color: Color,
    private val square: Square
): Piece(color, square) {
    override fun mainMove(): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()

        if (canMoveUp) {
            possibleMoves.add(square.add(1, 0))
        }
        if (canMoveUp && canMoveRight) {
            possibleMoves.add(square.add(1, 1))
        }
        if (canMoveUp && canMoveLeft) {
            possibleMoves.add(square.add(1, -1))
        }

        if (canMoveRight) {
            possibleMoves.add(square.add(0, 1))
        }
        if (canMoveLeft) {
            possibleMoves.add(square.add(0, -1))
        }

        if (canMoveDown) {
            possibleMoves.add(square.add(-1, 0))
        }
        if (canMoveDown && canMoveRight) {
            possibleMoves.add(square.add(-1, 1))
        }
        if (canMoveDown && canMoveLeft) {
            possibleMoves.add(square.add(-1, -1))
        }

        return possibleMoves
    }
}
