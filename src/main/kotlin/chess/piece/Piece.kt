package chess.piece

import chess.Color
import chess.square.*
import java.lang.Error
import kotlin.math.abs

abstract class Piece(
    private val color: Color,
    protected var square: Square,
    private val directions: List<Direction>,
    private val maxMove: Int? = null
) {
    open fun mainMove(): MainMovement {
        val mainMovement = MainMovement(mutableMapOf())

        for (direction in directions) {
            val index = maxMove ?: MaxMovement(direction, square).total()
            val possibleMoves: MutableList<Square> = mutableListOf()
            if (square.canMove(direction)) {
                for (i in 1..index) {
                    possibleMoves.add(square.move(direction, i))
                }
            }
            possibleMoves.forEach { square -> mainMovement.add(direction, square) }
        }

        return mainMovement
    }

    open fun journey(destination: PieceDestination): List<Square> {
        if (maxMove == 1) {
            return emptyList()
        }
        val movesList: MutableList<Square> = mutableListOf()
        var index: Int = destination.squaresBetween()
        if (index < 0) {
            index = abs(index)
        }
        println(index)
        for (i in 1..index) {
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
