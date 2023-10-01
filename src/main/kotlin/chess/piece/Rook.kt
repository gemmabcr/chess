package chess.piece

import chess.Color
import chess.board.Square

class Rook(
    private val color: Color,
    private val square: Square
): Piece(color, square)
