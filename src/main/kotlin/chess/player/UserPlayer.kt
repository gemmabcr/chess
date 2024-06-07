package chess.player

import chess.Color
import chess.ui.Ui
import chess.piece.Piece
import chess.square.Journey
import chess.square.Square

class UserPlayer(
    color: Color,
    private val ui: Ui
) : Player(color) {
    override fun pieceMovement(pieces: List<Piece>): Journey {
        val piece: Piece = ui.askPiece(pieces)
        val square: Square = ui.askSquare(piece.allPossibleMoves())
        return piece.getJourney(square)
    }
}
