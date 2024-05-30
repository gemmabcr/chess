package chess.piece

import chess.Color
import chess.square.Column
import chess.square.Row
import chess.square.Square
import kotlin.test.Test
import kotlin.test.assertEquals

internal class KnightTest {

    @Test
    fun givenKnightInCornerSquareWhenMainMoveThenReturnTwoPossiblesMoves() {
        val knight = Knight(Color.BLACK, Square(Column.A, Row.ONE))
        val list: List<Square> = listOf(
            Square(Column.B, Row.THREE),
            Square(Column.C, Row.TWO),
        )
        val result: List<Square> = knight.mainMove()
        assertEquals(list, result)
    }

    @Test
    fun givenKnightInCenterBoardWhenMainMoveThenReturnAllPossiblesMovementsAround() {
        val knight = Knight(Color.BLACK, Square(Column.D, Row.FOUR))
        val list: List<Square> = listOf(
            Square(Column.B, Row.FIVE),
            Square(Column.B, Row.THREE),
            Square(Column.C, Row.SIX),
            Square(Column.C, Row.TWO),
            Square(Column.E, Row.SIX),
            Square(Column.E, Row.TWO),
            Square(Column.F, Row.FIVE),
            Square(Column.F, Row.THREE),
        )
        val result: List<Square> = knight.mainMove()
        assertEquals(list, result)
    }
}