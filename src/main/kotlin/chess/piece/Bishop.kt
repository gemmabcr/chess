package chess.piece

import chess.Color
import chess.board.Square

class Bishop(
    private val color: Color,
    private val square: Square
): Piece(color, square) {
    override fun mainMove(): List<Square> {
        val maxRightRowMovement = square.row.maxUpMovement()
        val maxLeftRowMovement = square.row.maxDownMovement()
        val maxUpColumnMovement = square.column.maxRightMovement()
        val maxDownColumnMovement = square.column.maxLeftMovement()

        val maxPositiveMov = when {
            maxRightRowMovement < maxUpColumnMovement -> maxRightRowMovement
            else -> maxUpColumnMovement
        }
        val maxNegativeMov = when {
            maxLeftRowMovement < maxDownColumnMovement -> maxLeftRowMovement
            else -> maxDownColumnMovement
        }

        val possibleMoves: MutableList<Square> = mutableListOf()
        for (i in 1..maxPositiveMov) {
            possibleMoves.add(square.add(i, i))
        }
        for (i in 1 .. maxNegativeMov) {
            possibleMoves.add(square.add(-i, -i))
        }

        return possibleMoves.toList()
    }
}
