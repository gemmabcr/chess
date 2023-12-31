package chess.player

import chess.Color
import chess.ui.Ui
import chess.piece.Piece
import chess.piece.movement.PieceDestination
import chess.square.Square

class UserPlayer(
    private val color: Color,
    private val pieces: List<Piece>,
    private val ui: Ui
): Player(color, pieces) {
    override fun pieceMovement(): PieceDestination {
        val piece: Piece = ui.askPiece(pieces)
        val square: Square = ui.askSquare(piece.mainMove())
        return PieceDestination(piece, piece.getPosition(), square)
    }
}
