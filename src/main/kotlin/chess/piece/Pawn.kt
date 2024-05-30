package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Square

class Pawn(
    val color: Color,
    private val square: Square
) : Piece(color, square) {
    override fun mainMove(): MainMovement {
        val mainMovement = MainMovement()
        if (square.canMoveUp()) {
            mainMovement.addForward(square.move(0, 1))
            if (square.canMoveLeft()) {
                mainMovement.addUpLeft(square.move(-1, 1))
            }
            if (square.canMoveRight()) {
                mainMovement.addUpRight(square.move(1, 1))
            }
        }
        return mainMovement
    }

    override fun journey(destination: Square): List<Square> = emptyList()
}
