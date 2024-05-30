package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Square

class Queen(
    color: Color,
    val square: Square
) : Piece(color, square) {

    override fun mainMove(): MainMovement {
        var mainMovement = possibleDiagonalMoves()
        mainMovement = mainMovement.copy(possibleRankFileMoves())
        return mainMovement
    }

    override fun journey(destination: Square): List<Square> {
        TODO("Not yet implemented")
    }
}
