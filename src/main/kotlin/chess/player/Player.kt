package chess.player

import chess.Color
import chess.piece.PieceDestination

abstract class Player(
    private val color: Color,
) {
    abstract fun pieceMovement(): PieceDestination

    fun getColor(): Color = this.color
}
