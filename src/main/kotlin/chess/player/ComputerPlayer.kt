package chess.player

import chess.Color
import chess.piece.Piece
import chess.square.Journey
import kotlin.random.Random

class ComputerPlayer(
    color: Color,
) : Player(color) {

    override fun pieceMovement(pieces: List<Piece>): Journey {
        val index = Random.nextInt(0, pieces.size)
        val piece = pieces[index]
        return piece.getRandomJourney()
    }
}
