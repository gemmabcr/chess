package chess.piece.movement

import chess.square.Square
import chess.square.direction.Horizontal
import chess.square.direction.Vertical

class DiagonalMovement(
    private val square: Square,
) {
    private val canMoveUpRight = square.canMoveUp() && square.canMoveRight()
    private val canMoveDownRight = square.canMoveDown() && square.canMoveRight()
    private val canMoveDownLeft = square.canMoveDown() && square.canMoveLeft()
    private val canMoveUpLeft = square.canMoveUp() && square.canMoveLeft()

    fun possibleMoves(maxMove: Int): MainMovement {
        val mainMovement = MainMovement()

        diagonalSquares(
            Vertical.FORWARD,
            Horizontal.RIGHT,
            maxMove
        ).forEach { square -> mainMovement.addUpRight(square) }
        diagonalSquares(Vertical.FORWARD, Horizontal.LEFT, maxMove).forEach { square -> mainMovement.addUpLeft(square) }
        diagonalSquares(
            Vertical.BACKWARD,
            Horizontal.RIGHT,
            maxMove
        ).forEach { square -> mainMovement.addDownRight(square) }
        diagonalSquares(
            Vertical.BACKWARD,
            Horizontal.LEFT,
            maxMove
        ).forEach { square -> mainMovement.addDownLeft(square) }

        return mainMovement
    }

    private fun diagonalSquares(vertical: Vertical, horizontal: Horizontal, maxMove: Int): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()
        if (canMoveDiagonally(vertical, horizontal)) {
            val maxDiagonalMovement = when {
                maxMove != 8 -> maxMove
                else -> maxDiagonalMove(vertical, horizontal)
            }
            for (i in 1..maxDiagonalMovement) {
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
        dirVertical `is` Vertical.FORWARD && dirHorizontal `is` Horizontal.RIGHT -> canMoveUpRight
        dirVertical `is` Vertical.BACKWARD && dirHorizontal `is` Horizontal.RIGHT -> canMoveDownRight
        dirVertical `is` Vertical.BACKWARD && dirHorizontal `is` Horizontal.LEFT -> canMoveDownLeft
        else -> canMoveUpLeft
    }

    private fun maxDiagonalMove(dirVertical: Vertical, dirHorizontal: Horizontal): Int = when {
        getVertical(dirVertical) < getHorizontal(dirHorizontal) -> getVertical(dirVertical)
        else -> getHorizontal(dirHorizontal)
    }

    private fun getVertical(direction: Vertical) = when {
        direction `is` Vertical.FORWARD -> square.maxUpMovement()
        else -> square.maxDownMovement()
    }

    private fun getHorizontal(direction: Horizontal) = when {
        direction `is` Horizontal.RIGHT -> square.maxRightMovement()
        else -> square.maxLeftMovement()
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