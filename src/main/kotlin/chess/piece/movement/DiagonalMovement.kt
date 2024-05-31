package chess.piece.movement

import chess.square.Square
import chess.square.Direction

class DiagonalMovement(
    private val square: Square,
) {
    fun possibleMoves(maxMove: Int? = null): MainMovement {
        val mainMovement = MainMovement()

        diagonalSquares(
            Direction.FORWARD_RIGHT,
            maxMove ?: square.maxForwardRightMovement()
        ).forEach { square -> mainMovement.addUpRight(square) }
        diagonalSquares(
            Direction.FORWARD_LEFT,
            maxMove ?: square.maxForwardLeftMovement()
        ).forEach { square -> mainMovement.addUpLeft(square) }
        diagonalSquares(
            Direction.BACKWARD_RIGHT,
            maxMove ?: square.maxBackwardRightMovement()
        ).forEach { square -> mainMovement.addDownRight(square) }
        diagonalSquares(
            Direction.BACKWARD_LEFT,
            maxMove ?: square.maxBackwardLeftMovement()
        ).forEach { square -> mainMovement.addDownLeft(square) }

        return mainMovement
    }

    private fun diagonalSquares(direction: Direction, maxMove: Int): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()
        if (canMoveDiagonally(direction)) {
            for (i in 1 ..maxMove) {
                possibleMoves.add(square.move(direction, i))
            }
        }
        return possibleMoves
    }

    private fun canMoveDiagonally(direction: Direction): Boolean = when {
        direction `is` Direction.FORWARD_RIGHT -> square.canMoveForwardRight()
        direction `is` Direction.BACKWARD_RIGHT -> square.canMoveBackwardRight()
        direction `is` Direction.BACKWARD_LEFT -> square.canMoveBackwardLeft()
        direction `is` Direction.FORWARD_LEFT -> square.canMoveForwardLeft()
        else -> false
    }
}