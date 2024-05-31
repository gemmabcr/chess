package chess.piece

import chess.Color
import chess.square.Column
import chess.square.Row
import chess.square.Square

class PieceSetOut {
    companion object {
        fun setUp(color: Color): MutableList<Piece> = Column.all()
            .flatMap { column: Column ->
                listOf(
                    mainPiece(color, column, color.rowMainPiece()),
                    Pawn(color, Square(column, color.rowPawns())),
                )
            }.toMutableList()

        private fun mainPiece(color: Color, column: Column, row: Row): Piece = when {
            column `is` Column.A || column `is` Column.H -> Rook(color, Square(column, row))
            column `is` Column.B || column `is` Column.G -> Knight(color, Square(column, row))
            column `is` Column.C || column `is` Column.F -> Bishop(color, Square(column, row))
            column `is` Column.D -> Queen(color, Square(column, row))
            else -> King(color, Square(column, row))
        }
    }
}