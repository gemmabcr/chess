package chess

import chess.piece.Piece
import chess.position.Position

data class Movement(
    private val piece: Piece,
    private val destination: Position
) {}
