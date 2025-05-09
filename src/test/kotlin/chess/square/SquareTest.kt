package chess.square

import chess.Color
import kotlin.test.Test
import kotlin.test.assertEquals

internal class SquareTest {
    @Test
    fun givenColumnAndRowWhenCreatedThenReturnValues() {
        val column = Column.A
        val row = Row.ONE
        val square = Square(column, row)
        assertEquals(square.column, column)
        assertEquals(square.row, row)
        assertEquals(square.color, Color.BLACK)
    }

    @Test
    fun givenSquareWhenDirectionThenReturnDirectionWithDestination() {
        val square = Square(Column.D, Row.FOUR)
        assertEquals(Journey(Pair(square, Square(Column.D, Row.FIVE))).direction(), Direction.FORWARD)
        assertEquals(Journey(Pair(square, Square(Column.D, Row.THREE))).direction(), Direction.BACKWARD)
        assertEquals(Journey(Pair(square, Square(Column.C, Row.FOUR))).direction(), Direction.LEFT)
        assertEquals(Journey(Pair(square, Square(Column.E, Row.FOUR))).direction(), Direction.RIGHT)
        assertEquals(Journey(Pair(square, Square(Column.C, Row.FIVE))).direction(), Direction.FORWARD_LEFT)
        assertEquals(Journey(Pair(square, Square(Column.E, Row.FIVE))).direction(), Direction.FORWARD_RIGHT)
        assertEquals(Journey(Pair(square, Square(Column.C, Row.THREE))).direction(), Direction.BACKWARD_LEFT)
        assertEquals(Journey(Pair(square, Square(Column.E, Row.THREE))).direction(), Direction.BACKWARD_RIGHT)
    }

    @Test
    fun givenSquareWhenSquaresBetweenThenNumberOfSquaresBetween() {
        val square = Square(Column.D, Row.FOUR)
        assertEquals(Journey(Pair(square, Square(Column.F, Row.TWO))).squaresBetweenTotal(), 1)
        assertEquals(Journey(Pair(square, Square(Column.G, Row.FOUR))).squaresBetweenTotal(), 2)
        assertEquals(Journey(Pair(square, Square(Column.D, Row.EIGHT))).squaresBetweenTotal(), 3)
    }
}