package chess.piece

import chess.board.Square

data class PieceDestination(
    private val piece: Piece,
    private val destination: Square
) {}
