package chess.piece

import chess.Color
import chess.piece.movement.Movement
import chess.piece.movement.MainMovement
import chess.square.Direction
import chess.square.Square
import java.lang.Error

abstract class Piece(
    private val color: Color,
    private var square: Square,
    private val maxMove: Int? = null
) {
    private val movement: Movement = Movement(square, this.directions())

    abstract fun directions(): List<Direction>

    open fun mainMove(): MainMovement = movement.possibleMoves(maxMove)

    abstract fun journey(destination: Square): List<Square>

    fun move(destination: Square) {
        this.square = destination
    }

    open fun isKing(): Boolean = false

    fun `is`(color: Color): Boolean = this.color == color
    fun `is`(square: Square): Boolean = this.square == square

    fun getColor(): Color = this.color
    fun getPosition(): Square = this.square

    fun isValid(destination: Square): Boolean = mainMove().hasDestination(destination)

    fun randomMove(): Square {
        val moves = mainMove()
        if (moves.isEmpty()) {
            throw Error("This piece can not be moved")
        }
        return moves.random()
    }
}
