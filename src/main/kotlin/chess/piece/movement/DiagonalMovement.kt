package chess.piece.movement

import chess.square.Square
import chess.square.direction.Horizontal
import chess.square.direction.Vertical

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
            Vertical.FORWARD,
            Horizontal.RIGHT,
            maxMove ?: square.maxForwardRightMovement()
        ).forEach { square -> mainMovement.addUpRight(square) }
        diagonalSquares(
            Vertical.FORWARD,
            Horizontal.LEFT,
            maxMove ?: square.maxForwardLeftMovement()
        ).forEach { square ->
            mainMovement.addUpLeft(
                square
            )
        }
        diagonalSquares(
            Vertical.BACKWARD,
            Horizontal.RIGHT,
            maxMove ?: square.maxBackwardRightMovement()
        ).forEach { square -> mainMovement.addDownRight(square) }
        diagonalSquares(
            Vertical.BACKWARD,
            Horizontal.LEFT,
            maxMove ?: square.maxBackwardLeftMovement()
        ).forEach { square -> mainMovement.addDownLeft(square) }

        return mainMovement
    }

    private fun diagonalSquares(vertical: Vertical, horizontal: Horizontal, maxMove: Int): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()
        if (canMoveDiagonally(vertical, horizontal)) {
            for (i in 1 ..maxMove) {
                possibleMoves.add(
                    square.move(
                        getColumnIndex(horizontal, i),
                        getRowIndex(vertical, i)
                    )
                )
            }
        }
        return possibleMoves
    }

    private fun canMoveDiagonally(dirVertical: Vertical, dirHorizontal: Horizontal): Boolean = when {
        dirVertical `is` Vertical.FORWARD && dirHorizontal `is` Horizontal.RIGHT -> canMoveForwardRight
        dirVertical `is` Vertical.BACKWARD && dirHorizontal `is` Horizontal.RIGHT -> canMoveBackwardRight
        dirVertical `is` Vertical.BACKWARD && dirHorizontal `is` Horizontal.LEFT -> canMoveBackwardLeft
        else -> canMoveForwardLeft
    }

    private fun getColumnIndex(direction: Horizontal, index: Int) = when {
        direction `is` Horizontal.LEFT -> -index
        else -> index
    }

    private fun getRowIndex(direction: Vertical, index: Int) = when {
        direction `is` Vertical.BACKWARD -> -index
        else -> index
    }
}