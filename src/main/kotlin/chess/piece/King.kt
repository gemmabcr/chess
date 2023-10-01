package chess.piece

import chess.Color
import chess.board.Square

class King(
    private val color: Color,
    private val square: Square
): Piece(color, square)
