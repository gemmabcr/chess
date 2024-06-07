package chess.piece

import chess.Color
import chess.square.*

class Knight(
    color: Color,
    square: Square
) : Piece(color, square, Direction.diagonals()) {
    override fun mainMove(): MainMovement {
        val mainMovement = MainMovement(mutableMapOf())
        val controller = MovementController(Direction.FORWARD, square)

        val maxForwardMove: Int = controller.maxMovement()
        val maxRightMove: Int = controller.withDirection(Direction.RIGHT).maxMovement()
        val maxBackwardMove: Int = controller.withDirection(Direction.BACKWARD).maxMovement()
        val maxLeftMove: Int = controller.withDirection(Direction.LEFT).maxMovement()

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

    override fun journey(journey: Journey): List<Square> = emptyList()
}
