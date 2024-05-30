package chess.piece

import chess.Color
import chess.square.Column
import chess.square.Row
import chess.square.Square
import kotlin.test.Test
import kotlin.test.assertEquals

internal class KingTest {

    @Test
    fun givenKingInCornerSquareWhenMainMoveThenReturnAllFirstSquareAround() {
        val king = King(Color.BLACK, Square(Column.A, Row.ONE))
        val list: List<Square> = listOf(
            Square(Column.A, Row.TWO),
            Square(Column.B, Row.TWO),
            Square(Column.B, Row.ONE),
        )
        val result: List<Square> = king.mainMove()
        assertEquals(list, result)
    }

    @Test
    fun givenKingInCenterBoardWhenMainMoveThenReturnAllFirstSquareAround() {
        val king = King(Color.BLACK, Square(Column.D, Row.FOUR))
        val list: List<Square> = listOf(
            Square(Column.C, Row.FIVE),
            Square(Column.C, Row.THREE),
            Square(Column.C, Row.FOUR),
            Square(Column.D, Row.FIVE),
            Square(Column.D, Row.THREE),
            Square(Column.E, Row.FIVE),
            Square(Column.E, Row.THREE),
            Square(Column.E, Row.FOUR),
        )
        val result: List<Square> = king.mainMove()
        assertEquals(list, result)
    }
}