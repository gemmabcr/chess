package chess.ui

import chess.ChessResult
import chess.Color
import chess.piece.*
import chess.player.Player
import chess.square.Column
import chess.square.Square
import java.lang.Error

class Ui {
    fun askPiece(pieces: List<Piece>): Piece {
        print("Write the number of the piece you want to move:")
        println()
        pieces.forEachIndexed { index, piece -> println("${index}-> ${getPieceName(piece)}. ${piece.getPosition().toString()} ") }
        val piece = pieces[readln().toInt()]
        println("You are moving ${getPieceName(piece)}. ${piece.getPosition().toString()}")
        return piece
    }

    private fun getPieceName(piece: Piece): String = when (piece) {
        is King -> "King"
        is Queen -> "Queen"
        is Bishop -> "Bishop"
        is Knight -> "Knight"
        is Rook -> "Rook"
        is Pawn -> "Pawn"
        else -> throw Error("Incorrect piece")
    }

    fun askSquare(mainMove: List<Square>): Square {
        print("Write the number of the square you want to move:")
        println()
        mainMove.forEachIndexed { index, move -> println("${index}-> ${move.toString()} ") }
        val square = mainMove[readln().toInt()]
        println("You are moving to ${square.toString()}")
        return square
    }

    fun print(result: ChessResult) {
        println("Game is over: $result")
    }

    fun print(board: List<List<Square>>, pieces: List<Piece>) {
        val squares: MutableList<UiSquare> = mutableListOf()
        board.forEach { row -> row.forEach { square -> squares.add(UiSquare(getSquareColor(square.getColor()), square)) } }
        pieces.forEach { piece -> squares.find { square -> square.`is`(piece.getPosition()) }!!.changeIcon(piece) }
        newLine()
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
        newLine()
    }

    fun print(player: Player) {
        println()
        println("It is ${player.getColor()} player turn")
    }

    private fun newLine() {
        println()
        println("------------------------------")
        println()
    }

    private fun getSquareColor(color: Color): UiIcon = when (color) {
        Color.BLACK -> UiIcon.BLACK_SQUARE
        else -> UiIcon.WHITE_SQUARE
    }

    private fun printColumnValues() {
        return Column.all().forEach { column -> run {
            if (column.ordinal == 0) {
                print("""    ${Column.entries[0]} """)
            } else {
                print(""" ${Column.entries[column.ordinal]} """)
            }
        } }
    }

    fun invalidMove() {
        println("** Invalid move **")
    }
}
