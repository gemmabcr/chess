package chess.piece

import chess.Color
import chess.board.Square

class King(
    private val color: Color,
    private val square: Square
): Piece(color, square) {
    override fun mainMove(): List<Square> {
        val maxRightRowMovement = square.row.maxUpMovement()
        val maxLeftRowMovement = square.row.maxDownMovement()
        val maxUpColumnMovement = square.column.maxRightMovement()
        val maxDownColumnMovement = square.column.maxLeftMovement()

        val canMoveRight = maxRightRowMovement >= 1;
        val canMoveLeft = maxLeftRowMovement >= 1;
        val canMoveUp = maxUpColumnMovement >= 1;
        val canMoveDown = maxDownColumnMovement >= 1;

        val possibleMoves: MutableList<Square> = mutableListOf()
        if (canMoveRight) {
            possibleMoves.add(square.add(0, 1))
        }
        if (canMoveRight && canMoveUp) {
            possibleMoves.add(square.add(1, 1))
        }
        if (canMoveUp) {
            possibleMoves.add(square.add(1, 0))
        }
        if (canMoveLeft && canMoveUp) {
            possibleMoves.add(square.add(1, -1))
        }
        if (canMoveLeft) {
            possibleMoves.add(square.add(0, -1))
        }
        if (canMoveLeft && canMoveDown) {
            possibleMoves.add(square.add(-1, -1))
        }
        if (canMoveDown) {
            possibleMoves.add(square.add(-1, 0))
        }
        return possibleMoves
    }
}
