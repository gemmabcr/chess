package chess.piece

import chess.Color
import chess.square.Column
import chess.square.Row
import chess.square.Square
import kotlin.test.Test
import kotlin.test.assertEquals

internal class PawnTest {

    @Test
    fun givenPawnInCornerSquareWhenMainMoveThenReturnAllFirstSquareForward() {
        val pawn = Pawn(Color.BLACK, Square(Column.A, Row.ONE))
        val list: List<Square> = listOf(
            Square(Column.A, Row.TWO),
            Square(Column.B, Row.TWO),
        )
        val result: List<Square> = pawn.mainMove()
        assertEquals(list, result)
    }

    @Test
    fun givenPawnInCenterSquareWhenMainMoveThenReturnAllFirstSquareForward() {
        val pawn = Pawn(Color.BLACK, Square(Column.D, Row.FOUR))
        val list: List<Square> = listOf(
            Square(Column.C, Row.FIVE),
            Square(Column.D, Row.FIVE),
            Square(Column.E, Row.FIVE),
        )
        val result: List<Square> = pawn.mainMove()
        assertEquals(list, result)
    }
}