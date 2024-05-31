package chess.piece.movement

import chess.square.Square
import chess.square.Direction

class RankFileMovement(
    private val square: Square,
) {
    fun possibleMoves(maxMove: Int? = null): MainMovement {
        val mainMovement = MainMovement()

        rankFileSquares(
            Direction.FORWARD,
            maxMove ?: square.maxForwardMovement()
        ).forEach { square -> mainMovement.addForward(square) }
        rankFileSquares(
            Direction.BACKWARD,
            maxMove ?: square.maxBackwardMovement()
        ).forEach { square -> mainMovement.addBackward(square) }
        rankFileSquares(
            Direction.RIGHT,
            maxMove ?: square.maxRightMovement()
        ).forEach { square -> mainMovement.addRight(square) }
        rankFileSquares(
            Direction.LEFT,
            maxMove ?: square.maxLeftMovement()
        ).forEach { square -> mainMovement.addLeft(square) }

        return mainMovement
    }

    private fun rankFileSquares(direction: Direction, maxMove: Int): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()
        if (canMove(direction)) {
            for (i in 1..maxMove) {
                possibleMoves.add(square.move(direction, i))
            }
        }
        return possibleMoves
    }

    private fun canMove(direction: Direction): Boolean = when {
        direction `is` Direction.FORWARD -> square.canMoveForward()
        direction `is` Direction.BACKWARD -> square.canMoveBackward()
        direction `is` Direction.RIGHT -> square.canMoveRight()
        direction `is` Direction.LEFT -> square.canMoveLeft()
        else -> false
    }
}
