package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Direction
import chess.square.Square

class Knight(
    color: Color,
    private val square: Square
) : Piece(color, square) {
    override fun directions(): List<Direction> = Direction.diagonals()

    override fun mainMove(): MainMovement {
        val mainMovement = MainMovement()

        val maxForwardMove = square.maxForwardMovement()
        val maxRightMove = square.maxRightMovement()
        val maxBackwardMove = square.maxBackwardMovement()
        val maxLeftMove = square.maxLeftMovement()

        if (maxForwardMove >= 2) {
            if (maxRightMove >= 1) {
                mainMovement.add(Direction.FORWARD_RIGHT, square.move(1, 2))
            }
            if (maxLeftMove >= 1) {
                mainMovement.add(Direction.FORWARD_LEFT, square.move(-1, 2))
            }
        }
        if (maxForwardMove >= 1) {
            if (maxRightMove >= 2) {
                mainMovement.add(Direction.FORWARD_RIGHT, square.move(2, 1))
            }
            if (maxLeftMove >= 2) {
                mainMovement.add(Direction.FORWARD_LEFT, square.move(-2, 1))
            }
        }
        if (maxBackwardMove >= 1) {
            if (maxRightMove >= 2) {
                mainMovement.add(Direction.BACKWARD_RIGHT, square.move(2, -1))
            }
            if (maxLeftMove >= 2) {
                mainMovement.add(Direction.BACKWARD_LEFT, square.move(-2, -1))
            }
        }
        if (maxBackwardMove >= 2) {
            if (maxRightMove >= 1) {
                mainMovement.add(Direction.BACKWARD_RIGHT, square.move(1, -2))
            }
            if (maxLeftMove >= 1) {
                mainMovement.add(Direction.BACKWARD_LEFT, square.move(-1, -2))
            }
        }

        return mainMovement
    }

    override fun journey(destination: Square): List<Square> = emptyList()
}
