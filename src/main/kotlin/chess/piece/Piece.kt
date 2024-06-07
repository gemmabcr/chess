package chess.piece

import chess.Color
import chess.square.Direction
import chess.square.Square
import java.lang.Error
import kotlin.math.abs

abstract class Piece(
    private val color: Color,
    protected var square: Square,
    private val directions: List<Direction>,
    private val maxMove: Int? = null
) {
    private val movement: Movement = Movement(square, directions)

    open fun mainMove(): MainMovement = movement.possibleMoves(maxMove)

    open fun journey(destination: PieceDestination): List<Square> {
        if (maxMove == 1) {
            return emptyList()
        }
        val movesList: MutableList<Square> = mutableListOf()
        for (i in 1..<abs(destination.squaresBetween())) {
            movesList.add(square.move(destination.direction(), i))
        }
        return movesList.toList()
    }

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
