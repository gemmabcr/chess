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
                    mainPiece(color, column, color.mainPieceRow),
                    Pawn(color, Square(column, color.pawnsRow)),
                )
            }.toMutableList()

        private fun mainPiece(color: Color, column: Column, row: Row): Piece = when (column) {
            Column.A, Column.H -> Rook(color, Square(column, row))
            Column.B, Column.G -> Knight(color, Square(column, row))
            Column.C, Column.F -> Bishop(color, Square(column, row))
            Column.D -> Queen(color, Square(column, row))
            Column.E -> King(color, Square(column, row))
        }
    }
}