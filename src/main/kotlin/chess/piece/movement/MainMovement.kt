package chess.piece.movement

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

    fun addUpRight(square: Square) {
        forwardRight.add(square)
        forwardRight.sortBy { it.getColumn() }
    }

    fun addUpLeft(square: Square) {
        forwardLeft.add(square)
        forwardLeft.sortBy { it.getColumn() }
    }

    fun addDownRight(square: Square) {
        backwardRight.add(square)
        backwardRight.sortBy { it.getColumn() }
    }

    fun addDownLeft(square: Square) {
        backwardLeft.add(square)
        backwardLeft.sortBy { it.getColumn() }
    }

    fun addForward(square: Square) {
        forward.add(square)
        forward.sortBy { it.getRow() }
    }

    fun addBackward(square: Square) {
        backward.add(square)
        backward.sortBy { it.getRow() }
    }

    fun addRight(square: Square) {
        right.add(square)
        right.sortBy { it.getColumn() }
    }

    fun addLeft(square: Square) {
        left.add(square)
        left.sortBy { it.getColumn() }
    }

    fun hasDestination(destination: Square): Boolean = allSquares().any { square -> square.`is`(destination) }

    fun isEmpty(): Boolean = allSquares().isEmpty()

    fun random(): Square = allSquares().random()

    fun copy(moves: MainMovement): MainMovement {
        val forwardCopy = forward + moves.forward
        val backwardCopy = backward + moves.backward
        val leftCopy = left + moves.left
        val rightCopy = right + moves.right
        val upLeftDiagonalCopy = forwardLeft + moves.forwardLeft
        val downLeftDiagonalCopy = backwardLeft + moves.backwardLeft
        val upRightDiagonalCopy = forwardRight + moves.forwardRight
        val downRightDiagonalCopy = backwardRight + moves.backwardRight


        return MainMovement(
            forward = forwardCopy.sortedBy { it.getRow() }.toMutableList(),
            backward = backwardCopy.sortedBy { it.getRow() }.toMutableList(),
            left = leftCopy.sortedBy { it.getColumn() }.toMutableList(),
            right = rightCopy.sortedBy { it.getColumn() }.toMutableList(),
            forwardLeft = upLeftDiagonalCopy.sortedBy { it.getColumn() }.toMutableList(),
            backwardLeft = downLeftDiagonalCopy.sortedBy { it.getColumn() }.toMutableList(),
            forwardRight = upRightDiagonalCopy.sortedBy { it.getColumn() }.toMutableList(),
            backwardRight = downRightDiagonalCopy.sortedBy { it.getColumn() }.toMutableList(),
        )
    }
}