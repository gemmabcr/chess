package chess.piece

import chess.Color
import chess.square.*
import java.lang.Error

sealed class Piece(
    private val color: Color,
    protected var square: Square,
    private val directions: List<Direction>,
    private val maxMove: Int? = null
) {
    open fun mainMove(): MainMovement {
        val mainMovement = MainMovement(mutableMapOf())

        for (direction in directions) {
            val controller = MovementController(direction, square)
            val index = maxMove ?: controller.maxMovement()
            val possibleMoves: MutableList<Square> = mutableListOf()
            if (controller.canMove()) {
                for (i in 1..index) {
                    possibleMoves.add(square.move(direction, i))
                }
            }
            possibleMoves.forEach { square -> mainMovement.add(direction, square) }
        }

        return mainMovement
    }

    open fun journey(journey: Journey): List<Square> {
        if (maxMove == 1) {
            return emptyList()
        }
        return journey.squaresBetween()
    }

    fun move(destination: Square) {
        this.square = destination
    }

    open fun isKing(): Boolean = false

    fun `is`(color: Color): Boolean = this.color == color

    fun `is`(square: Square): Boolean = this.square == square

    fun getPosition(): Square = this.square

    fun hasSameColor(piece: Piece): Boolean = color == piece.color

    fun enemyColor(): Color = color.opposite()

    fun hasPosition(origin: Square): Boolean = square.`is`(origin)

    fun getRandomJourney(): Journey = Journey(Pair(square, randomMove()))

    private fun randomMove(): Square {
        val moves = mainMove()
        if (moves.isEmpty()) {
            throw Error("This piece can not be moved")
        }
        return moves.random()
    }

    fun getJourney(square: Square): Journey {
        return Journey(Pair(getPosition(), square))
    }

    fun allPossibleMoves(): List<Square> = mainMove().allSquares()

    fun canMove(): Boolean = allPossibleMoves().isNotEmpty()
}
