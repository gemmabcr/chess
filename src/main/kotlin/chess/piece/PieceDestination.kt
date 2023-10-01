package chess.piece

import chess.square.Square

data class PieceDestination(
    private val piece: Piece,
    private val destination: Square
) {}
