package chess.piece

import chess.Color
import chess.square.Direction
import chess.square.Square

class Rook(
    color: Color,
    square: Square
) : Piece(color, square, Direction.straights())
