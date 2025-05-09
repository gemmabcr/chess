package chess.square

import kotlin.collections.component1
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class ColumnTest {

    @Test
    fun givenColumnWhenIsThenReturnTrueIfTheyAreEqual() {
        val column: Column = Column.A
        assertTrue(column `is` Column.A)
        assertFalse(column `is` Column.B)
    }

    @Test
    fun givenColumnWhenMaxLeftMovementThenReturnNumberOfMaxMovementToTheLeft() {
        val maxLeftMovement = mapOf(
            Column.A to 0,
            Column.B to 1,
            Column.C to 2,
            Column.D to 3,
            Column.E to 4,
            Column.F to 5,
            Column.G to 6,
            Column.H to 7,
        )
        maxLeftMovement.forEach { (column, max) ->
            assertEquals(max, column.maxLeftMovement())
        }
    }

    @Test
    fun givenColumnWhenMaxRightMovementThenReturnNumberOfMaxMovementToTheRight() {
        val maxRightMovement = mapOf(
            Column.A to 7,
            Column.B to 6,
            Column.C to 5,
            Column.D to 4,
            Column.E to 3,
            Column.F to 2,
            Column.G to 1,
            Column.H to 0,
        )
        maxRightMovement.forEach { (column, max) ->
            assertEquals(max, column.maxRightMovement())
        }
    }

    @Test
    fun givenColumnWhenCanMoveRightThenReturnTrueIfItIsNotLastColumn() {
        val canMoveRight = mapOf(
            Column.A to true,
            Column.B to true,
            Column.C to true,
            Column.D to true,
            Column.E to true,
            Column.F to true,
            Column.G to true,
            Column.H to false,
        )
        canMoveRight.forEach { (column, canMove) ->
            assertEquals(canMove, column.canMoveRight())
        }
    }

    @Test
    fun givenColumnWhenCanMoveLeftThenReturnTrueIfItIsNotFirstColumn() {
        val canMoveLeft = mapOf(
            Column.A to false,
            Column.B to true,
            Column.C to true,
            Column.D to true,
            Column.E to true,
            Column.F to true,
            Column.G to true,
            Column.H to true,
        )
        canMoveLeft.forEach { (column, canMove) ->
            assertEquals(canMove, column.canMoveLeft())
        }
    }

    @Test
    fun givenIntWhenMoveThenReturnResultColumn() {
        assertEquals(Column.A.move(2), Column.C)
        assertEquals(Column.C.move(-2), Column.A)
        assertEquals(Column.H.move(-2), Column.F)
    }
}