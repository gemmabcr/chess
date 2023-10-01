package chess.piece

import chess.Color
import chess.board.Square

class Bishop(
    private val color: Color,
    private val square: Square
): Piece(color, square) {
    override fun mainMove(): List<Square> {
        val rowsUp = square.maxUpMovement()
        val rowsDown = square.maxDownMovement()
        val columnsRight = square.maxRightMovement()
        val columnsLeft = square.maxLeftMovement()

        val possibleMoves: MutableList<Square> = mutableListOf()

        if (square.canMoveUp() && square.canMoveRight()) {
            val rightUpMov = when {
                rowsUp < columnsRight -> rowsUp
                else -> columnsRight
            }
            for (i in 1..rightUpMov) {
                possibleMoves.add(square.add(i, i))
            }
        }

        if (square.canMoveUp() && square.canMoveLeft()) {
            val leftUpMov = when {
                rowsUp < columnsLeft -> rowsUp
                else -> columnsLeft
            }
            for (i in 1..leftUpMov) {
                possibleMoves.add(square.add(i, -i))
            }
        }

        if (square.canMoveDown() && square.canMoveRight()) {
            val rightDownMov = when {
                rowsDown < columnsRight -> rowsDown
                else -> columnsRight
            }
            for (i in 1..rightDownMov) {
                possibleMoves.add(square.add(-i, i))
            }
        }

        if (square.canMoveDown() && square.canMoveLeft()) {
            val leftDownMov = when {
                rowsDown < columnsLeft -> rowsDown
                else -> columnsLeft
            }
            for (i in 1..leftDownMov) {
                possibleMoves.add(square.add(-i, -i))
            }
        }

        return possibleMoves.toList()
    }
}
