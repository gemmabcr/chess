package chess.board

import chess.square.Column
import chess.square.Row
import chess.square.Square

class Board {
    private val squares: List<List<Square>> = createBoard()

    private fun createBoard(): List<List<Square>> {
        return Row.all().map { row: Row ->
            Column.all().map { column: Column ->
                Square(column, row)
            }
        }
    }
}