package chess.piece

import chess.square.Direction
import chess.square.Square

data class PieceDestination(
    val piece: Piece,
    val destination: Square
) {
    fun direction(): Direction = piece.getPosition().direction(destination)

    fun squaresBetween(): Int = piece.getPosition().squaresBetween(destination)
}
