package chess.board

import chess.Color
import chess.position.Column
import chess.position.Row

class Square(
    val column: Column,
    val row: Row
) {
    private val color: Color = setColor()

    private fun setColor(): Color = when {
        columnIsPair() && rowIsPair() -> Color.BLACK
        !columnIsPair() && !rowIsPair() -> Color.BLACK
        else -> Color.WHITE
    }

    private fun columnIsPair(): Boolean {
        return column.ordinal % 2 != 0
    }

    private fun rowIsPair(): Boolean {
        return row.ordinal % 2 != 0
    }

    fun add(columnMove: Int, rowMove: Int): Square = Square(column.add(columnMove), row.add(rowMove))
}