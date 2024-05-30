package chess.piece.movement

import chess.square.Square
import chess.square.direction.Diagonal

class DiagonalMovement(
    private val square: Square,
) {
    private val canMoveForwardRight = square.canMoveForward() && square.canMoveRight()
    private val canMoveBackwardRight = square.canMoveBackward() && square.canMoveRight()
    private val canMoveBackwardLeft = square.canMoveBackward() && square.canMoveLeft()
    private val canMoveForwardLeft = square.canMoveForward() && square.canMoveLeft()

    fun possibleMoves(maxMove: Int? = null): MainMovement {
        val mainMovement = MainMovement()

        diagonalSquares(
            Diagonal.FORWARD_RIGHT,
            maxMove ?: square.maxForwardRightMovement()
        ).forEach { square -> mainMovement.addUpRight(square) }
        diagonalSquares(
            Diagonal.FORWARD_LEFT,
            maxMove ?: square.maxForwardLeftMovement()
        ).forEach { square ->
            mainMovement.addUpLeft(
                square
            )
        }
        diagonalSquares(
            Diagonal.BACKWARD_RIGHT,
            maxMove ?: square.maxBackwardRightMovement()
        ).forEach { square -> mainMovement.addDownRight(square) }
        diagonalSquares(
            Diagonal.BACKWARD_LEFT,
            maxMove ?: square.maxBackwardLeftMovement()
        ).forEach { square -> mainMovement.addDownLeft(square) }

        return mainMovement
    }

    private fun diagonalSquares(diagonal: Diagonal, maxMove: Int): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()
        if (canMoveDiagonally(diagonal)) {
            for (i in 1 ..maxMove) {
                possibleMoves.add(
                    square.move(diagonal, i)
                )
            }
        }
        return possibleMoves
    }

    private fun canMoveDiagonally(diagonal: Diagonal): Boolean = when {
        diagonal `is` Diagonal.FORWARD_RIGHT -> canMoveForwardRight
        diagonal `is` Diagonal.BACKWARD_RIGHT -> canMoveBackwardRight
        diagonal `is` Diagonal.BACKWARD_LEFT -> canMoveBackwardLeft
        else -> canMoveForwardLeft
    }
}