package chess.piece

import chess.Color
import chess.square.Square

class Knight(
    private val color: Color,
    private val square: Square
): Piece(color, square) {
    override fun mainMove(): List<Square> {
        val movesList: MutableList<Square> = mutableListOf()

        val maxUpMove = square.maxUpMovement()
        val maxRightMove = square.maxRightMovement()
        val maxDownMove = square.maxDownMovement()
        val maxLeftMove = square.maxLeftMovement()

        if (maxUpMove >= 2 && maxRightMove >= 1) {
            movesList.add(square.move(1, 2))
        }
        if (maxRightMove >= 2 && maxUpMove >= 1) {
            movesList.add(square.move(2, 1))
        }
        if (maxRightMove >= 2 && maxDownMove >= 1) {
            movesList.add(square.move(2, -1))
        }
        if (maxDownMove >= 2 && maxRightMove >= 1) {
            movesList.add(square.move(1, -2))
        }
        if (maxUpMove >= 2 && maxLeftMove >= 1) {
            movesList.add(square.move(-1, 2))
        }
        if (maxLeftMove >= 2 && maxUpMove >= 1) {
            movesList.add(square.move(-2, 1))
        }
        if (maxLeftMove >= 2 && maxDownMove >= 1) {
            movesList.add(square.move(-2, -1))
        }
        if (maxLeftMove >= 2 && maxRightMove >= 1) {
            movesList.add(square.move(-1, -2))
        }

        return movesList.toList()
    }
    override fun journey(destination: Square): List<Square> = emptyList()
}
