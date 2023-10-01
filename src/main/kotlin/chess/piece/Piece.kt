package chess.piece

import chess.Color
import chess.piece.movement.DiagonalMovement
import chess.piece.movement.RankFileMovement
import chess.square.Square

abstract class Piece(
    private val color: Color,
    private val square: Square
) {
    private val diagonalMovement: DiagonalMovement = DiagonalMovement(square)
    private val rankFileMovement: RankFileMovement = RankFileMovement(square)

    abstract fun mainMove(): List<Square>
    fun possibleDiagonalMoves(maxMove: Int = 8): List<Square> = diagonalMovement.possibleMoves(maxMove)
    fun possibleRankFileMoves(maxMove: Int = 8): List<Square> = rankFileMovement.possibleMoves(maxMove)
}
