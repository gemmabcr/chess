package chess.player

import chess.Color
import chess.piece.Piece
import chess.piece.PieceDestination
import kotlin.random.Random

class ComputerPlayer(
    private val color: Color,
    private val pieces: List<Piece>
): Player(color) {

    override fun pieceMovement(): PieceDestination {
        val index = Random.nextInt(0, pieces.size)
        val piece = pieces[index]
        return PieceDestination(piece, piece.getPosition(), piece.randomMove())
    }
}
