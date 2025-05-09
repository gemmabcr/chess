package chess.square

import chess.Color
import kotlin.collections.component1
import kotlin.collections.component2
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
        val directions = mapOf(
            Square(Column.D, Row.FIVE) to Direction.FORWARD,
            Square(Column.D, Row.THREE) to Direction.BACKWARD,
            Square(Column.C, Row.FOUR) to Direction.LEFT,
            Square(Column.E, Row.FOUR) to Direction.RIGHT,
            Square(Column.C, Row.FIVE) to Direction.FORWARD_LEFT,
            Square(Column.E, Row.FIVE) to Direction.FORWARD_RIGHT,
            Square(Column.C, Row.THREE) to Direction.BACKWARD_LEFT,
            Square(Column.E, Row.THREE) to Direction.BACKWARD_RIGHT,
        )

        directions.forEach { (goal, direction) ->
            assertEquals(createJourney(square, goal).direction(), direction)
        }
    }

    private fun createJourney(initial: Square, final: Square): Journey = Journey(Pair(initial, final))

    @Test
    fun givenSquareWhenSquaresBetweenThenNumberOfSquaresBetween() {
        val square = Square(Column.D, Row.FOUR)
        val squaresBetween = mapOf(
            Square(Column.F, Row.TWO) to 1,
            Square(Column.G, Row.FOUR) to 2,
            Square(Column.D, Row.EIGHT) to 3,
        )

        squaresBetween.forEach { (goal, squares) ->
            assertEquals(createJourney(square, goal).squaresBetweenTotal(), squares)
        }
    }
}