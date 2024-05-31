package chess.piece.movement

import chess.square.Direction
import chess.square.Square

data class MainMovement(
    private val moves: MutableMap<Direction, MutableList<Square>>,
) {
    fun allSquares(): List<Square> = moves.values.flatMap { it }.toList()

    fun add(direction:Direction, square: Square) {
        if (!moves.containsKey(direction)) {
            moves.put(direction, mutableListOf())
        }
        moves[direction]!!.add(square)
        if (direction `is` Direction.FORWARD || direction `is` Direction.BACKWARD) {
            moves[direction]!!.sortBy { it.getRow() }
        } else {
            moves[direction]!!.sortBy { it.getColumn() }
        }
    }

    fun hasDestination(destination: Square): Boolean = allSquares().any { square -> square.`is`(destination) }

    fun isEmpty(): Boolean = allSquares().isEmpty()

    fun random(): Square = allSquares().random()
}