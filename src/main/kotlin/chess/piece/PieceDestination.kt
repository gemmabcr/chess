package chess.piece

import chess.square.Direction
import chess.square.Journey
import chess.square.Square

data class PieceDestination(
    val piece: Piece,
    val destination: Square
) {
    fun direction(): Direction = Journey(Pair(piece.getPosition(), destination)).direction()

    fun squaresBetween(): Int = Journey(Pair(piece.getPosition(), destination)).squaresBetween()
}
