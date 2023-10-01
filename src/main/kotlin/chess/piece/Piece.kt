package chess.piece

import chess.Color
import chess.piece.movement.DiagonalMovement
import chess.piece.movement.RankFileMovement
import chess.square.Square
import java.lang.Error
import kotlin.random.Random

abstract class Piece(
    private val color: Color,
    private val square: Square
) {
    private val diagonalMovement: DiagonalMovement = DiagonalMovement(square)
    private val rankFileMovement: RankFileMovement = RankFileMovement(square)

    abstract fun mainMove(): List<Square>
    abstract fun journey(destination: Square): List<Square>

    fun `is`(color: Color): Boolean = this.color == color
    fun `is`(square: Square): Boolean = this.square == square
    fun isValid(destination: Square): Boolean = mainMove().contains(destination)

    fun randomMove(): Square {
        val moves = mainMove()
        if (moves.isEmpty()) {
            throw Error("This piece can not be moved")
        }
        val index = Random.nextInt(0, moves.size)
        return moves[index]
    }

    fun possibleDiagonalMoves(maxMove: Int = 8): List<Square> = diagonalMovement.possibleMoves(maxMove)
    fun possibleRankFileMoves(maxMove: Int = 8): List<Square> = rankFileMovement.possibleMoves(maxMove)
}
