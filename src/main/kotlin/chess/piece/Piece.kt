package chess.piece

import chess.Color
import chess.position.Position

abstract class Piece(
    private val color: Color,
    private val position: Position
) {}
