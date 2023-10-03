package chess.piece.pieces

import chess.Color
import chess.ChessResult
import chess.piece.Piece
import chess.piece.movement.PieceDestination
import chess.square.Square

class Pieces {
    private val pieces: MutableList<Piece> = InitialPieces.setUp()

    fun color(color: Color): List<Piece> {
        return pieces.filter { piece -> piece.`is`(color) }
    }

    fun isValid(movement: PieceDestination): Boolean {
        val correctMove = movement.piece.isValid(movement.destination)
        if (!correctMove) {
            return false
        }
        val journey = movement.piece.journey(movement.destination)
        return journey.find { square -> isPlenty(square) } == null
    }

    private fun isPlenty(square: Square): Boolean = pieces.find { piece -> piece.`is`(square) } != null

    fun hasResult(): Boolean {
        TODO("Not yet implemented")
    }

    fun result(): ChessResult {
        TODO("Not yet implemented")
    }
}