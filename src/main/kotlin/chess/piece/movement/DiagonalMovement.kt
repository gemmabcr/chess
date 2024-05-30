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

    fun possibleMoves(maxMove: Int): List<Square> {
        val movesList: MutableList<Square> = mutableListOf()

        diagonalSquares(Vertical.UP, Horizontal.RIGHT, maxMove).forEach { square -> movesList.add(square) }
        diagonalSquares(Vertical.UP, Horizontal.LEFT, maxMove).forEach { square -> movesList.add(square) }
        diagonalSquares(Vertical.DOWN, Horizontal.RIGHT, maxMove).forEach { square -> movesList.add(square) }
        diagonalSquares(Vertical.DOWN, Horizontal.LEFT, maxMove).forEach { square -> movesList.add(square) }

        return movesList.sortedBy { it.getColumn() }.toList()
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

    private fun canMoveDiagonally(dirVertical: Vertical, dirHorizontal: Horizontal) :Boolean = when {
        dirVertical `is` Vertical.UP && dirHorizontal `is` Horizontal.RIGHT -> canMoveUpRight
        dirVertical `is` Vertical.DOWN && dirHorizontal `is` Horizontal.RIGHT -> canMoveDownRight
        dirVertical `is` Vertical.DOWN && dirHorizontal `is` Horizontal.LEFT -> canMoveDownLeft
        else -> canMoveUpLeft
    }

    private fun maxDiagonalMove(dirVertical: Vertical, dirHorizontal: Horizontal): Int = when {
        getVertical(dirVertical) < getHorizontal(dirHorizontal) -> getVertical(dirVertical)
        else -> getHorizontal(dirHorizontal)
    }

    private fun getVertical(direction: Vertical) = when {
        direction `is` Vertical.UP -> square.maxUpMovement()
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
        direction `is` Vertical.DOWN -> -index
        else -> index
    }
}