package chess.piece

import chess.Color
import chess.board.Square

abstract class Piece(
    private val color: Color,
    private val square: Square
) {}
