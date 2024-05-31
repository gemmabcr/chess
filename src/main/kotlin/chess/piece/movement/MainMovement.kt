package chess.piece.movement

import chess.square.Direction
import chess.square.Square

data class MainMovement(
    private val forward: MutableList<Square> = mutableListOf(),
    private val backward: MutableList<Square> = mutableListOf(),
    private val left: MutableList<Square> = mutableListOf(),
    private val right: MutableList<Square> = mutableListOf(),
    private val forwardLeft: MutableList<Square> = mutableListOf(),
    private val backwardLeft: MutableList<Square> = mutableListOf(),
    private val forwardRight: MutableList<Square> = mutableListOf(),
    private val backwardRight: MutableList<Square> = mutableListOf(),
) {
    fun allSquares(): List<Square> =
        forward + backward + left + right + forwardLeft + backwardLeft + forwardRight + backwardRight

    private fun addForwardRight(square: Square) {
        forwardRight.add(square)
        forwardRight.sortBy { it.getColumn() }
    }

    private fun addForwardLeft(square: Square) {
        forwardLeft.add(square)
        forwardLeft.sortBy { it.getColumn() }
    }

    private fun addBackwardRight(square: Square) {
        backwardRight.add(square)
        backwardRight.sortBy { it.getColumn() }
    }

    private fun addBackwardLeft(square: Square) {
        backwardLeft.add(square)
        backwardLeft.sortBy { it.getColumn() }
    }

    private fun addForward(square: Square) {
        forward.add(square)
        forward.sortBy { it.getRow() }
    }

    private fun addBackward(square: Square) {
        backward.add(square)
        backward.sortBy { it.getRow() }
    }

    private fun addRight(square: Square) {
        right.add(square)
        right.sortBy { it.getColumn() }
    }

    private fun addLeft(square: Square) {
        left.add(square)
        left.sortBy { it.getColumn() }
    }

    fun hasDestination(destination: Square): Boolean = allSquares().any { square -> square.`is`(destination) }

    fun isEmpty(): Boolean = allSquares().isEmpty()

    fun random(): Square = allSquares().random()

    fun add(direction: Direction, square: Square) = when {
        direction `is` Direction.FORWARD -> addForward(square)
        direction `is` Direction.LEFT -> addLeft(square)
        direction `is` Direction.BACKWARD -> addBackward(square)
        direction `is` Direction.RIGHT -> addRight(square)
        direction `is` Direction.FORWARD_LEFT -> addForwardLeft(square)
        direction `is` Direction.BACKWARD_LEFT -> addBackwardLeft(square)
        direction `is` Direction.BACKWARD_RIGHT -> addBackwardRight(square)
        direction `is` Direction.FORWARD_RIGHT -> addForwardRight(square)
        else -> throw Exception("Can't add square with $direction")
    }
}