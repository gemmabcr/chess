package chess.piece

import chess.Color
import chess.square.Direction
import chess.square.Square

class Pawn(
    color: Color,
    square: Square
) : Piece(color, square, Direction.forwards(), 1)
