package chess

import chess.board.Square
import chess.piece.Piece

data class Movement(
    private val piece: Piece,
    private val destination: Square
) {}
