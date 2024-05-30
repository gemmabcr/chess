package chess.piece

import chess.Color
import chess.square.Column
import chess.square.Row
import chess.square.Square
import kotlin.test.Test
import kotlin.test.assertEquals

internal class BishopTest {

    @Test
    fun givenBishopInFirstSquareWhenMainMoveThenReturnAllSquaresRightDiagonal() {
        val bishop = Bishop(Color.BLACK, Square(Column.A, Row.ONE))
        val list: List<Square> = listOf(
            Square(Column.B, Row.TWO),
            Square(Column.C, Row.THREE),
            Square(Column.D, Row.FOUR),
            Square(Column.E, Row.FIVE),
            Square(Column.F, Row.SIX),
            Square(Column.G, Row.SEVEN),
            Square(Column.H, Row.EIGHT)
        )
        val result: List<Square> = bishop.mainMove()
        assertEquals(list, result)
    }

    @Test
    fun givenBishopInCenterBoardWhenMainMoveThenReturnAllSquaresInAllSidesDiagonal() {
        val bishop = Bishop(Color.BLACK, Square(Column.D, Row.FOUR))
        val list: List<Square> = listOf(
            Square(Column.A, Row.SEVEN),
            Square(Column.A, Row.ONE),
            Square(Column.B, Row.SIX),
            Square(Column.B, Row.TWO),
            Square(Column.C, Row.FIVE),
            Square(Column.C, Row.THREE),
            Square(Column.E, Row.FIVE),
            Square(Column.E, Row.THREE),
            Square(Column.F, Row.SIX),
            Square(Column.F, Row.TWO),
            Square(Column.G, Row.SEVEN),
            Square(Column.G, Row.ONE),
            Square(Column.H, Row.EIGHT),
        )
        val result: List<Square> = bishop.mainMove()
        assertEquals(list, result)
    }
}