package chess.piece.movement

import chess.piece.Piece
import chess.square.Square

data class PieceDestination(
    val piece: Piece,
    val destination: Square
) {}
