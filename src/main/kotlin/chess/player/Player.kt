package chess.player

import chess.Color
import chess.piece.Piece
import chess.piece.PieceDestination

abstract class Player(
    private val color: Color,
    private val pieces: List<Piece>
) {
    abstract fun pieceMovement(): PieceDestination
    fun getColor(): Color = this.color
}
