package chess.ui

import chess.ChessResult
import chess.Color
import chess.piece.Piece
import chess.square.Column
import chess.square.Square

class Ui {
    fun askPiece(): Piece {
        TODO("Not yet implemented")
    }

    fun askSquare(): Square {
        TODO("Not yet implemented")
    }

    fun print(result: ChessResult) {
        println("Game is over: $result")
    }

    fun print(board: List<List<Square>>, pieces: List<Piece>) {
        val squares: MutableList<UiSquare> = mutableListOf()
        board.forEach { row -> row.forEach { square -> squares.add(UiSquare(getSquareColor(square.getColor()), square)) } }
        pieces.forEach { piece -> squares.find { square -> square.`is`(piece.getPosition()) }!!.changeIcon(piece) }
        for (i in 0 .. 7) {
            if (i == 0) {
                printColumnValues()
                println()
            }
            val row = squares.filter { uiSquare -> uiSquare.isRowIndex(i) }
            for (j in 0 .. 7) {
                if (j == 0) {
                    print(""" ${8 - i} """)
                }
                print(""" ${row[j].icon.icon} """)
                if (j == 7) {
                    print(""" ${8 - i} """)
                }
            }
            println()
            if (i == 7) {
                printColumnValues()
            }
        }
    }

    private fun getSquareColor(color: Color): UiIcon = when (color) {
        Color.BLACK -> UiIcon.BLACK_SQUARE
        else -> UiIcon.WHITE_SQUARE
    }

    private fun printColumnValues(): Unit {
        return Column.all().forEach { column -> run {
            if (column.ordinal == 0) {
                print("""    ${Column.entries[column.ordinal]} """)
            } else {
                print(""" ${Column.entries[column.ordinal]} """)
            }
        } }
    }
}
