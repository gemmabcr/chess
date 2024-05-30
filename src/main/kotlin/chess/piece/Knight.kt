package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Square

class Knight(
    val color: Color,
    private val square: Square
) : Piece(color, square) {
    override fun mainMove(): MainMovement {
        val mainMovement = MainMovement()

        val maxUpMove = square.maxUpMovement()
        val maxRightMove = square.maxRightMovement()
        val maxDownMove = square.maxDownMovement()
        val maxLeftMove = square.maxLeftMovement()

        if (maxUpMove >= 2) {
            if (maxRightMove >= 1) {
                mainMovement.addUpRight(square.move(1, 2))
            }
            if (maxLeftMove >= 1) {
                mainMovement.addUpLeft(square.move(-1, 2))
            }
        }
        if (maxUpMove >= 1) {
            if (maxRightMove >= 2) {
                mainMovement.addUpRight(square.move(2, 1))
            }
            if (maxLeftMove >= 2) {
                mainMovement.addUpLeft(square.move(-2, 1))
            }
        }
        if (maxDownMove >= 1) {
            if (maxRightMove >= 2) {
                mainMovement.addDownRight(square.move(2, -1))
            }
            if (maxLeftMove >= 2) {
                mainMovement.addDownLeft(square.move(-2, -1))
            }
        }
        if (maxDownMove >= 2) {
            if (maxRightMove >= 1) {
                mainMovement.addDownRight(square.move(1, -2))
            }
            if (maxLeftMove >= 1) {
                mainMovement.addDownLeft(square.move(-1, -2))
            }
        }

        return mainMovement
    }

    override fun journey(destination: Square): List<Square> = emptyList()
}
