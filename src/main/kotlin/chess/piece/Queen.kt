package chess.piece

import chess.Color
import chess.square.Square

class Queen(
    private val color: Color,
    private val square: Square
): Piece(color, square) {
    override fun mainMove(): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()
        possibleDiagonalMoves().forEach { square -> possibleMoves.add(square) }

        if (canMoveUp) {
            for (i in 1..rowsUp) {
                possibleMoves.add(square.add(i, 0))
            }
        }

        if (canMoveRight) {
            for (i in 1..columnsRight) {
                possibleMoves.add(square.add(0, i))
            }
        }

        if (canMoveDown) {
            for (i in 1..rowsDown) {
                possibleMoves.add(square.add(-i, 0))
            }
        }

        if (canMoveLeft) {
            for (i in 1..columnsLeft) {
                possibleMoves.add(square.add(0, -i))
            }
        }

        return possibleMoves.toList()
    }
}
