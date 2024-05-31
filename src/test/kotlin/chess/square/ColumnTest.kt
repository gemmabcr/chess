package chess.square

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
        assertEquals(Column.A.maxLeftMovement(), 0)
        assertEquals(Column.B.maxLeftMovement(), 1)
        assertEquals(Column.C.maxLeftMovement(), 2)
        assertEquals(Column.D.maxLeftMovement(), 3)
        assertEquals(Column.E.maxLeftMovement(), 4)
        assertEquals(Column.F.maxLeftMovement(), 5)
        assertEquals(Column.G.maxLeftMovement(), 6)
        assertEquals(Column.H.maxLeftMovement(), 7)
    }

    @Test
    fun givenColumnWhenMaxRightMovementThenReturnNumberOfMaxMovementToTheRight() {
        assertEquals(Column.A.maxRightMovement(), 7)
        assertEquals(Column.B.maxRightMovement(), 6)
        assertEquals(Column.C.maxRightMovement(), 5)
        assertEquals(Column.D.maxRightMovement(), 4)
        assertEquals(Column.E.maxRightMovement(), 3)
        assertEquals(Column.F.maxRightMovement(), 2)
        assertEquals(Column.G.maxRightMovement(), 1)
        assertEquals(Column.H.maxRightMovement(), 0)
    }

    @Test
    fun givenColumnWhenCanMoveRightThenReturnTrueIfItIsNotLastColumn() {
        assertTrue(Column.A.canMoveRight())
        assertTrue(Column.B.canMoveRight())
        assertTrue(Column.C.canMoveRight())
        assertTrue(Column.D.canMoveRight())
        assertTrue(Column.E.canMoveRight())
        assertTrue(Column.F.canMoveRight())
        assertTrue(Column.G.canMoveRight())
        assertFalse(Column.H.canMoveRight())
    }

    @Test
    fun givenColumnWhenCanMoveLeftThenReturnTrueIfItIsNotFirstColumn() {
        assertFalse(Column.A.canMoveLeft())
        assertTrue(Column.B.canMoveLeft())
        assertTrue(Column.C.canMoveLeft())
        assertTrue(Column.D.canMoveLeft())
        assertTrue(Column.E.canMoveLeft())
        assertTrue(Column.F.canMoveLeft())
        assertTrue(Column.G.canMoveLeft())
        assertTrue(Column.H.canMoveLeft())
    }

    @Test
    fun givenIntWhenMoveThenReturnResultColumn() {
        assertEquals(Column.A.move(2), Column.C)
        assertEquals(Column.C.move(-2), Column.A)
        assertEquals(Column.H.move(-2), Column.F)
    }
}