package chess.piece

import chess.Color
import chess.square.Column
import chess.square.Row
import chess.square.Square

class Pieces {
    private val pieces: MutableList<Piece> = piecesSetUp()

    private fun piecesSetUp(): MutableList<Piece> {
        return Column.all().flatMap { column: Column ->
            listOf(
                mainPiece(Color.WHITE, column, Row.ONE),
                Pawn(Color.WHITE, Square(column, Row.TWO)),
                Pawn(Color.BLACK, Square(column, Row.SEVEN)),
                mainPiece(Color.BLACK, column, Row.EIGHT),
            )
        }.toMutableList()
    }

    private fun mainPiece(color: Color, column: Column, row: Row): Piece = when {
        column `is` Column.A || column `is` Column.H -> Rook(color, Square(column, row))
        column `is` Column.B || column `is` Column.G -> Knight(color, Square(column, row))
        column `is` Column.C || column `is` Column.F -> Bishop(color, Square(column, row))
        column `is` Column.D -> Queen(color, Square(column, row))
        else -> King(color, Square(column, row))
    }

    fun color(color: Color): List<Piece> {
        return pieces.filter { piece -> piece.`is`(color) }
    }
}