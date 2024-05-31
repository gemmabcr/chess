package chess.piece.movement

import chess.square.Square
import chess.square.Direction

class Movement(
    private val square: Square,
    private val directions: List<Direction>
) {
    fun possibleMoves(maxMove: Int? = null): MainMovement {
        val mainMovement = MainMovement(mutableMapOf())

        for(direction in directions) {
            squares(
                direction,
                maxMove ?: maxMovement(direction)
            ).forEach { square -> mainMovement.add(direction, square) }
        }

        return mainMovement
    }

    private fun maxMovement(direction: Direction): Int = when {
        direction `is` Direction.FORWARD -> square.maxForwardMovement()
        direction `is` Direction.LEFT -> square.maxLeftMovement()
        direction `is` Direction.BACKWARD -> square.maxBackwardMovement()
        direction `is` Direction.RIGHT -> square.maxRightMovement()
        direction `is` Direction.FORWARD_LEFT -> square.maxForwardLeftMovement()
        direction `is` Direction.BACKWARD_LEFT -> square.maxBackwardLeftMovement()
        direction `is` Direction.BACKWARD_RIGHT -> square.maxBackwardRightMovement()
        direction `is` Direction.FORWARD_RIGHT -> square.maxForwardRightMovement()
        else -> 0
    }

    private fun squares(direction: Direction, maxMove: Int): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()
        if (square.canMove(direction)) {
            for (i in 1 ..maxMove) {
                possibleMoves.add(square.move(direction, i))
            }
        }
        return possibleMoves
    }
}