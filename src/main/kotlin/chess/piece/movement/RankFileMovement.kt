package chess.piece.movement

import chess.square.Square
import chess.square.direction.Horizontal
import chess.square.direction.Vertical

class RankFileMovement(
    private val square: Square,
){
    private val canMoveUp = square.canMoveUp()
    private val canMoveRight = square.canMoveRight()
    private val canMoveDown = square.canMoveDown()
    private val canMoveLeft = square.canMoveLeft()

    fun possibleMoves(maxMove: Int): MainMovement {
        val mainMovement = MainMovement()

        rankSquares(Vertical.FORWARD, maxMove).forEach { square -> mainMovement.addForward(square) }
        rankSquares(Vertical.BACKWARD, maxMove).forEach { square -> mainMovement.addBackward(square) }
        fileSquares(Horizontal.RIGHT, maxMove).forEach { square -> mainMovement.addRight(square) }
        fileSquares(Horizontal.LEFT, maxMove).forEach { square -> mainMovement.addLeft(square) }

        return mainMovement
    }

    private fun rankSquares(vertical: Vertical, maxMove: Int): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()
        if (canRankMove(vertical)) {
            val maxRankMovement = when {
                maxMove != 8 -> maxMove
                else -> maxRankMove(vertical)
            }
            for (i in 1..maxRankMovement) {
                possibleMoves.add(
                    square.move(
                        0,
                        getRankIndex(vertical, i)
                    )
                )
            }
        }
        return possibleMoves
    }

    private fun fileSquares(horizontal: Horizontal, maxMove: Int): List<Square> { // File is row
        val possibleMoves: MutableList<Square> = mutableListOf()
        if (canFileMove(horizontal)) {
            val maxFileMovement = when {
                maxMove != 8 -> maxMove
                else -> maxFileMove(horizontal)
            }
            for (i in 1..maxFileMovement) {
                possibleMoves.add(
                    square.move(
                        getFileIndex(horizontal, i),
                        0
                    )
                )
            }
        }
        return possibleMoves
    }

    private fun canRankMove(direction: Vertical) :Boolean = when {
        direction `is` Vertical.FORWARD -> canMoveUp
        else -> canMoveDown
    }

    private fun canFileMove(direction: Horizontal) :Boolean = when {
        direction `is` Horizontal.RIGHT -> canMoveRight
        else -> canMoveLeft
    }

    private fun maxRankMove(direction: Vertical): Int = when {
        direction `is` Vertical.FORWARD -> square.maxUpMovement()
        else -> square.maxDownMovement()
    }

    private fun maxFileMove(direction: Horizontal): Int = when {
        direction `is` Horizontal.RIGHT -> square.maxRightMovement()
        else -> square.maxLeftMovement()
    }

    private fun getRankIndex(direction: Vertical, index: Int) = when {
        direction `is` Vertical.BACKWARD -> -index
        else -> index
    }

    private fun getFileIndex(direction: Horizontal, index: Int) = when {
        direction `is` Horizontal.LEFT -> -index
        else -> index
    }
}
