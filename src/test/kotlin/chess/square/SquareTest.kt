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
        assertEquals(square.getColumn(), column)
        assertEquals(square.getRow(), row)
        assertEquals(square.getColor(), Color.BLACK)
    }

    @Test
    fun givenSquareWhenDirectionThenReturnDirectionWithDestination() {
        val square = Square(Column.D, Row.FOUR)
        assertEquals(square.direction(Square(Column.D, Row.FIVE)), Direction.FORWARD)
        assertEquals(square.direction(Square(Column.D, Row.THREE)), Direction.BACKWARD)
        assertEquals(square.direction(Square(Column.C, Row.FOUR)), Direction.LEFT)
        assertEquals(square.direction(Square(Column.E, Row.FOUR)), Direction.RIGHT)
        assertEquals(square.direction(Square(Column.C, Row.FIVE)), Direction.FORWARD_LEFT)
        assertEquals(square.direction(Square(Column.E, Row.FIVE)), Direction.FORWARD_RIGHT)
        assertEquals(square.direction(Square(Column.C, Row.THREE)), Direction.BACKWARD_LEFT)
        assertEquals(square.direction(Square(Column.E, Row.THREE)), Direction.BACKWARD_RIGHT)
    }

    @Test
    fun givenSquareWhenSquaresBetweenThenNumberOfSquaresBetween() {
        val square = Square(Column.D, Row.FOUR)
        assertEquals(square.squaresBetween(Square(Column.F, Row.TWO)), 1)
        assertEquals(square.squaresBetween(Square(Column.G, Row.FOUR)), 2)
        assertEquals(square.squaresBetween(Square(Column.D, Row.EIGHT)), 3)
    }
}