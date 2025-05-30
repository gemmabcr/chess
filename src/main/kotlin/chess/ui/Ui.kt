package chess.ui

import chess.ChessResult
import chess.Color
import chess.piece.*
import chess.player.Player
import chess.square.Column
import chess.square.Square

class Ui {
    fun askPiece(pieces: List<Piece>): Piece {
        print("Write the number of the piece you want to move:\n")
        pieces.forEachIndexed { index, piece -> println("${index}-> ${getPieceName(piece)}. ${piece.getPosition()} ") }
        val piece = pieces[readln().toInt()]
        println("You are moving ${getPieceName(piece)}. ${piece.getPosition()}")
        return piece
    }

    private fun getPieceName(piece: Piece): String = piece.javaClass.simpleName

    fun askSquare(mainMove: List<Square>): Square {
        print("Write the number of the square you want to move:\n")
        mainMove.forEachIndexed { index, move -> println("${index}-> $move ") }
        val square = mainMove[readln().toInt()]
        println("You are moving to $square")
        return square
    }

    fun print(result: ChessResult) {
        println("Game is over: $result")
    }

    fun print(board: List<List<Square>>, pieces: List<Piece>) {
        val squares: MutableList<UiSquare> = mutableListOf()
        board.forEach { row -> row.forEach { square -> squares.add(UiSquare(getSquareColor(square.color), square)) } }
        pieces.forEach { piece -> squares.find { square -> square.`is`(piece.getPosition()) }!!.changeIcon(piece) }
        boardBorderLine()
        for (i in 0 .. 7) {
            if (i == 0) {
                printColumnValues()
                println()
            }
            val row = squares.filter { uiSquare -> uiSquare.isRowIndex(i) }
            for (j in 0 .. 7) {
                val printNumbers = { print(""" ${i+1} """) }
                if (j == 0) {
                    printNumbers()
                }
                print(""" ${row[j].icon.icon} """)
                if (j == 7) {
                    printNumbers()
                }
            }
            println()
            if (i == 7) {
                printColumnValues()
            }
        }
        boardBorderLine()
    }

    fun print(player: Player) = println("\nIt is ${player.color} player turn")

    private fun boardBorderLine() = println("\n------------------------------")

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
