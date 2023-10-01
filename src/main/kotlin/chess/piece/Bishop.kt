package chess.piece

import chess.Color
import chess.board.Square

class Bishop(
    private val color: Color,
    private val square: Square
): Piece(color, square)
