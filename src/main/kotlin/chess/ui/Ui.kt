package chess.ui

import chess.ChessResult
import chess.Color
import chess.piece.Piece
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
        for (i in 0 .. 8) {
            squares.filter { uiSquare -> uiSquare.isRowIndex(i) }.forEach { uiSquare ->
                println(uiSquare.icon)
            }
        }
    }

    private fun getSquareColor(color: Color): UiIcon = when (color) {
        Color.BLACK -> UiIcon.BLACK_SQUARE
        else -> UiIcon.WHITE_SQUARE
    }
}
