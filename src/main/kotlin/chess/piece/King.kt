package chess.piece

import chess.Color
import chess.board.Square

class King(
    private val color: Color,
    private val square: Square
): Piece(color, square) {
    override fun mainMove(): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()

        if (square.canMoveUp()) {
            possibleMoves.add(square.add(1, 0))
        }
        if (square.canMoveUp() && square.canMoveRight()) {
            possibleMoves.add(square.add(1, 1))
        }
        if (square.canMoveUp() && square.canMoveLeft()) {
            possibleMoves.add(square.add(1, -1))
        }

        if (square.canMoveRight()) {
            possibleMoves.add(square.add(0, 1))
        }
        if (square.canMoveLeft()) {
            possibleMoves.add(square.add(0, -1))
        }

        if (square.canMoveDown()) {
            possibleMoves.add(square.add(-1, 0))
        }
        if (square.canMoveDown() && square.canMoveRight()) {
            possibleMoves.add(square.add(-1, 1))
        }
        if (square.canMoveDown() && square.canMoveLeft()) {
            possibleMoves.add(square.add(-1, -1))
        }

        return possibleMoves
    }
}
