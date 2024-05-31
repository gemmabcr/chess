package chess.piece

import chess.square.Square

data class PieceDestination(
    val piece: Piece,
    val origin: Square,
    val destination: Square
) {}
