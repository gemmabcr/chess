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
        ).forEach { square -> mainMovement.addForwardRight(square) }
        diagonalSquares(
            Direction.FORWARD_LEFT,
            maxMove ?: square.maxForwardLeftMovement()
        ).forEach { square -> mainMovement.addForwardLeft(square) }
        diagonalSquares(
            Direction.BACKWARD_RIGHT,
            maxMove ?: square.maxBackwardRightMovement()
        ).forEach { square -> mainMovement.addBackwardRight(square) }
        diagonalSquares(
            Direction.BACKWARD_LEFT,
            maxMove ?: square.maxBackwardLeftMovement()
        ).forEach { square -> mainMovement.addBackwardLeft(square) }

        return mainMovement
    }

    private fun diagonalSquares(direction: Direction, maxMove: Int): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()
        if (square.canMove(direction)) {
            for (i in 1 ..maxMove) {
                possibleMoves.add(square.move(direction, i))
            }
        }
        return possibleMoves
    }
}