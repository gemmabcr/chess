package chess.square

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class RowTest {

    @Test
    fun givenRowWhenMaxForwardMovementThenReturnNumberOfMaxMovementToTheForward() {
        assertEquals(Row.EIGHT.maxForwardMovement(), 0)
        assertEquals(Row.SEVEN.maxForwardMovement(), 1)
        assertEquals(Row.SIX.maxForwardMovement(), 2)
        assertEquals(Row.FIVE.maxForwardMovement(), 3)
        assertEquals(Row.FOUR.maxForwardMovement(), 4)
        assertEquals(Row.THREE.maxForwardMovement(), 5)
        assertEquals(Row.TWO.maxForwardMovement(), 6)
        assertEquals(Row.ONE.maxForwardMovement(), 7)
    }

    @Test
    fun givenRowWhenMaxBackwardMovementThenReturnNumberOfMaxMovementToTheBackward() {
        assertEquals(Row.EIGHT.maxBackwardMovement(), 7)
        assertEquals(Row.SEVEN.maxBackwardMovement(), 6)
        assertEquals(Row.SIX.maxBackwardMovement(), 5)
        assertEquals(Row.FIVE.maxBackwardMovement(), 4)
        assertEquals(Row.FOUR.maxBackwardMovement(), 3)
        assertEquals(Row.THREE.maxBackwardMovement(), 2)
        assertEquals(Row.TWO.maxBackwardMovement(), 1)
        assertEquals(Row.ONE.maxBackwardMovement(), 0)
    }

    @Test
    fun givenRowWhenCanMoveBackwardThenReturnTrueIfItIsNotLastRow() {
        assertTrue(Row.EIGHT.canMoveBackward())
        assertTrue(Row.SEVEN.canMoveBackward())
        assertTrue(Row.SIX.canMoveBackward())
        assertTrue(Row.FIVE.canMoveBackward())
        assertTrue(Row.FOUR.canMoveBackward())
        assertTrue(Row.THREE.canMoveBackward())
        assertTrue(Row.TWO.canMoveBackward())
        assertFalse(Row.ONE.canMoveBackward())
    }

    @Test
    fun givenRowWhenCanMoveForwardThenReturnTrueIfItIsNotFirstRow() {
        assertFalse(Row.EIGHT.canMoveForward())
        assertTrue(Row.SEVEN.canMoveForward())
        assertTrue(Row.SIX.canMoveForward())
        assertTrue(Row.FIVE.canMoveForward())
        assertTrue(Row.FOUR.canMoveForward())
        assertTrue(Row.THREE.canMoveForward())
        assertTrue(Row.TWO.canMoveForward())
        assertTrue(Row.ONE.canMoveForward())
    }

    @Test
    fun givenIntWhenMoveThenReturnResultRow() {
        assertEquals(Row.FOUR.move(2), Row.SIX)
        assertEquals(Row.EIGHT.move(-2), Row.SIX)
        assertEquals(Row.THREE.move(-2), Row.ONE)
    }
}