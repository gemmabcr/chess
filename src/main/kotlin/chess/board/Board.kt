package chess.board

import chess.Color
import chess.Movement
import chess.piece.*
import chess.position.Column
import chess.position.Row

class Board {
    private val squares: List<List<Square>> = createBoard()
    private val pieces: List<Piece> = piecesSetUp()

    private fun createBoard(): List<List<Square>> {
        return Row.all().map { row: Row ->
            Column.all().map { column: Column ->
                Square(column, row)
            }
        }
    }

    private fun piecesSetUp(): List<Piece> {
        return Column.all().flatMap { column: Column ->
            listOf(
                mainPiece(Color.WHITE, column, Row.ONE),
                Pawn(Color.WHITE, Square(column, Row.TWO)),
                Pawn(Color.BLACK, Square(column, Row.SEVEN)),
                mainPiece(Color.BLACK, column, Row.EIGHT),
            )
        }
    }

    private fun mainPiece(color: Color, column: Column, row: Row): Piece = when {
        column `is` Column.A || column `is` Column.H -> Rook(color, Square(column, row))
        column `is` Column.B || column `is` Column.G -> Knight(color, Square(column, row))
        column `is` Column.C || column `is` Column.F -> Bishop(color, Square(column, row))
        column `is` Column.D -> Queen(color, Square(column, row))
        else -> King(color, Square(column, row))
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