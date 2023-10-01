package chess.player

import chess.Color
import chess.ui.Ui
import chess.piece.Piece
import chess.piece.movement.PieceDestination
import chess.square.Square

class UserPlayer(
    private val color: Color,
    private val ui: Ui
): Player(color) {
    override fun pieceMovement(): PieceDestination {
        val piece: Piece = ui.askPiece()
        val square: Square = ui.askSquare()
        return PieceDestination(piece, square)
    }
}
