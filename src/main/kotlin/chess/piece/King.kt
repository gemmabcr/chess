package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Square

class King(
    val color: Color,
    val square: Square
) : Piece(color, square) {

    override fun mainMove(): MainMovement {
        var mainMovement = possibleDiagonalMoves(1)
        mainMovement = mainMovement.copy(possibleRankFileMoves(1))
        return mainMovement
    }

    override fun journey(destination: Square): List<Square> = emptyList()

    override fun isKing(): Boolean = true
}
