package chess.piece.pieces

import chess.Color
import chess.board.ChessResult
import chess.piece.Piece
import chess.piece.movement.PieceDestination

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
        TODO("Not yet implemented")
    }

    fun hasResult(): Boolean {
        TODO("Not yet implemented")
    }

    fun result(): ChessResult {
        TODO("Not yet implemented")
    }
}