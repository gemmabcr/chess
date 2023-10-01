package chess.player

import chess.Color
import chess.piece.movement.PieceDestination

abstract class Player(
    private val color: Color
) {
    abstract fun pieceMovement(): PieceDestination
}
