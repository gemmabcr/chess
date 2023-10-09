package chess.player

import chess.Color
import chess.piece.Piece
import chess.piece.movement.PieceDestination
import kotlin.random.Random

class ComputerPlayer(
    private val color: Color,
    private val pieces: List<Piece>
): Player(color, pieces) {

    override fun pieceMovement(): PieceDestination {
        val index = Random.nextInt(0, pieces.size)
        val piece = pieces[index]
        return PieceDestination(piece, piece.randomMove())
    }
}
