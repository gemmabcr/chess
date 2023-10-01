package chess.piece

import chess.Color
import chess.position.Position

class Knight(
    private val color: Color,
    private val position: Position
): Piece(color, position)
