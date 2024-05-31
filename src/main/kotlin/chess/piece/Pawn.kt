package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Direction
import chess.square.Square

class Pawn(
    color: Color,
    private val square: Square
) : Piece(color, square) {
    override fun mainMove(): MainMovement {
        val mainMovement = MainMovement()
        if (square.canMove(Direction.FORWARD)) {
            mainMovement.addForward(square.move(0, 1))
            if (square.canMove(Direction.FORWARD_LEFT)) {
                mainMovement.addForwardLeft(square.move(-1, 1))
            }
            if (square.canMove(Direction.FORWARD_RIGHT)) {
                mainMovement.addForwardRight(square.move(1, 1))
            }
        }
        return mainMovement
    }

    override fun journey(destination: Square): List<Square> = emptyList()
}
