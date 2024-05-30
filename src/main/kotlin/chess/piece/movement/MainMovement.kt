package chess.piece.movement

import chess.square.Square

data class MainMovement(
    private val forward: MutableList<Square> = mutableListOf(),
    private val backward: MutableList<Square> = mutableListOf(),
    private val left: MutableList<Square> = mutableListOf(),
    private val right: MutableList<Square> = mutableListOf(),
    private val upLeftDiagonal: MutableList<Square> = mutableListOf(),
    private val downLeftDiagonal: MutableList<Square> = mutableListOf(),
    private val upRightDiagonal: MutableList<Square> = mutableListOf(),
    private val downRightDiagonal: MutableList<Square> = mutableListOf(),
) {
    fun allSquares(): List<Square> =
        forward + backward + left + right + upLeftDiagonal + downLeftDiagonal + upRightDiagonal + downRightDiagonal

    fun addUpRight(square: Square) {
        upRightDiagonal.add(square)
        upRightDiagonal.sortBy { it.getColumn() }
    }

    fun addUpLeft(square: Square) {
        upLeftDiagonal.add(square)
        upLeftDiagonal.sortBy { it.getColumn() }
    }

    fun addDownRight(square: Square) {
        downRightDiagonal.add(square)
        downRightDiagonal.sortBy { it.getColumn() }
    }

    fun addDownLeft(square: Square) {
        downLeftDiagonal.add(square)
        downLeftDiagonal.sortBy { it.getColumn() }
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
        val upLeftDiagonalCopy = upLeftDiagonal + moves.upLeftDiagonal
        val downLeftDiagonalCopy = downLeftDiagonal + moves.downLeftDiagonal
        val upRightDiagonalCopy = upRightDiagonal + moves.upRightDiagonal
        val downRightDiagonalCopy = downRightDiagonal + moves.downRightDiagonal


        return MainMovement(
            forward = forwardCopy.sortedBy { it.getRow() }.toMutableList(),
            backward = backwardCopy.sortedBy { it.getRow() }.toMutableList(),
            left = leftCopy.sortedBy { it.getColumn() }.toMutableList(),
            right = rightCopy.sortedBy { it.getColumn() }.toMutableList(),
            upLeftDiagonal = upLeftDiagonalCopy.sortedBy { it.getColumn() }.toMutableList(),
            downLeftDiagonal = downLeftDiagonalCopy.sortedBy { it.getColumn() }.toMutableList(),
            upRightDiagonal = upRightDiagonalCopy.sortedBy { it.getColumn() }.toMutableList(),
            downRightDiagonal = downRightDiagonalCopy.sortedBy { it.getColumn() }.toMutableList(),
        )
    }
}