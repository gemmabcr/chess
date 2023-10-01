package chess.piece.movement

import chess.piece.Piece
import chess.square.Square

data class PieceDestination(
    private val piece: Piece,
    private val destination: Square
) {}
