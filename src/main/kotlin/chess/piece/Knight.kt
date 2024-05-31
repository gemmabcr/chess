package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Square

class Knight(
    color: Color,
    private val square: Square
) : Piece(color, square) {
    override fun mainMove(): MainMovement {
        val mainMovement = MainMovement()

        val maxUpMove = square.maxForwardMovement()
        val maxRightMove = square.maxRightMovement()
        val maxDownMove = square.maxBackwardMovement()
        val maxLeftMove = square.maxLeftMovement()

        if (maxUpMove >= 2) {
            if (maxRightMove >= 1) {
                mainMovement.addForwardRight(square.move(1, 2))
            }
            if (maxLeftMove >= 1) {
                mainMovement.addForwardLeft(square.move(-1, 2))
            }
        }
        if (maxUpMove >= 1) {
            if (maxRightMove >= 2) {
                mainMovement.addForwardRight(square.move(2, 1))
            }
            if (maxLeftMove >= 2) {
                mainMovement.addForwardLeft(square.move(-2, 1))
            }
        }
        if (maxDownMove >= 1) {
            if (maxRightMove >= 2) {
                mainMovement.addBackwardRight(square.move(2, -1))
            }
            if (maxLeftMove >= 2) {
                mainMovement.addBackwardLeft(square.move(-2, -1))
            }
        }
        if (maxDownMove >= 2) {
            if (maxRightMove >= 1) {
                mainMovement.addBackwardRight(square.move(1, -2))
            }
            if (maxLeftMove >= 1) {
                mainMovement.addBackwardLeft(square.move(-1, -2))
            }
        }

        return mainMovement
    }

    override fun journey(destination: Square): List<Square> = emptyList()
}
