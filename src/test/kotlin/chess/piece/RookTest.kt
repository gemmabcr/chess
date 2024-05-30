package chess.piece

import chess.Color
import chess.square.Column
import chess.square.Row
import chess.square.Square
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RookTest {

    @Test
    fun givenRookInCornerSquareWhenMainMoveThenReturnAllForwardAndOneSidedSquare() {
        val rook = Rook(Color.BLACK, Square(Column.A, Row.ONE))
        val list: List<Square> = listOf(
            Square(Column.A, Row.TWO),
            Square(Column.A, Row.THREE),
            Square(Column.A, Row.FOUR),
            Square(Column.A, Row.FIVE),
            Square(Column.A, Row.SIX),
            Square(Column.A, Row.SEVEN),
            Square(Column.A, Row.EIGHT),
            Square(Column.B, Row.ONE),
            Square(Column.C, Row.ONE),
            Square(Column.D, Row.ONE),
            Square(Column.E, Row.ONE),
            Square(Column.F, Row.ONE),
            Square(Column.G, Row.ONE),
            Square(Column.H, Row.ONE),
        )
        val result: List<Square> = rook.mainMove()
        assertEquals(list, result)
    }

    @Test
    fun givenRookInCenterSquareWhenMainMoveThenReturnAllFourDirectionsStraightSquares() {
        val rook = Rook(Color.BLACK, Square(Column.D, Row.FOUR))
        val list: List<Square> = listOf(
            Square(Column.A, Row.FOUR),
            Square(Column.B, Row.FOUR),
            Square(Column.C, Row.FOUR),
            Square(Column.D, Row.FIVE),
            Square(Column.D, Row.SIX),
            Square(Column.D, Row.SEVEN),
            Square(Column.D, Row.EIGHT),
            Square(Column.D, Row.THREE),
            Square(Column.D, Row.TWO),
            Square(Column.D, Row.ONE),
            Square(Column.E, Row.FOUR),
            Square(Column.F, Row.FOUR),
            Square(Column.G, Row.FOUR),
            Square(Column.H, Row.FOUR),
        )
        val result: List<Square> = rook.mainMove()
        assertEquals(list, result)
    }
}