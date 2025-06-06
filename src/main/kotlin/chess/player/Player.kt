package chess.player

import chess.Color
import chess.piece.Piece
import chess.square.Journey

abstract class Player(val color: Color) {
    abstract fun pieceMovement(pieces: List<Piece>): Journey
}
