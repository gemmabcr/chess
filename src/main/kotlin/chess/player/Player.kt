package chess.player

import chess.Color
import chess.piece.Piece
import chess.square.Journey

abstract class Player(
    private val color: Color,
) {
    abstract fun pieceMovement(pieces: List<Piece>): Journey

    fun getColor(): Color = this.color
}
