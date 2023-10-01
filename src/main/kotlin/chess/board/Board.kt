package chess.board

import chess.Movement
import chess.piece.Piece

class Board {
    private val squares: List<List<Square>> = createBoard()
    private val pieces: List<Piece> = piecesSetUp()

    private fun createBoard(): List<List<Square>> {
        TODO()
    }

    private fun piecesSetUp(): List<Piece> {
        TODO()
    }

    fun isValid(move: Movement): Boolean {
        TODO()
    }

    fun hasResult(): Boolean {
        TODO()
    }

    fun result(): ChessResult {
        TODO("Not yet implemented")
    }
}