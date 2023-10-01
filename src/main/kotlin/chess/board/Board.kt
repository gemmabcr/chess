package chess.board

import chess.piece.movement.PieceDestination
import chess.piece.*
import chess.square.Column
import chess.square.Row
import chess.square.Square

class Board(
    private val pieces: Pieces
) {
    private val squares: List<List<Square>> = createBoard()

    private fun createBoard(): List<List<Square>> {
        return Row.all().map { row: Row ->
            Column.all().map { column: Column ->
                Square(column, row)
            }
        }
    }

    fun isValid(move: PieceDestination): Boolean {
        TODO()
    }

    fun hasResult(): Boolean {
        TODO()
    }

    fun result(): ChessResult {
        TODO("Not yet implemented")
    }
}