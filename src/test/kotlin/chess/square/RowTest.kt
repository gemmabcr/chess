package chess.square

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class RowTest {

    @Test
    fun givenRowWhenMaxForwardMovementThenReturnNumberOfMaxMovementToTheForward() {
        val maxForwardMovement = mapOf(
            Row.EIGHT to 0,
            Row.SEVEN to 1,
            Row.SIX to 2,
            Row.FIVE to 3,
            Row.FOUR to 4,
            Row.THREE to 5,
            Row.TWO to 6,
            Row.ONE to 7,
        )
        maxForwardMovement.forEach { (row, max) ->
            assertEquals(max, row.maxForwardMovement())
        }
    }

    @Test
    fun givenRowWhenMaxBackwardMovementThenReturnNumberOfMaxMovementToTheBackward() {
        val maxBackwardMovement = mapOf(
            Row.EIGHT to 7,
            Row.SEVEN to 6,
            Row.SIX to 5,
            Row.FIVE to 4,
            Row.FOUR to 3,
            Row.THREE to 2,
            Row.TWO to 1,
            Row.ONE to 0,
        )
        maxBackwardMovement.forEach { (row, max) ->
            assertEquals(max, row.maxBackwardMovement())
        }
    }

    @Test
    fun givenRowWhenCanMoveBackwardThenReturnTrueIfItIsNotLastRow() {
        val canMoveBackward = mapOf(
            Row.EIGHT to true,
            Row.SEVEN to true,
            Row.SIX to true,
            Row.FIVE to true,
            Row.FOUR to true,
            Row.THREE to true,
            Row.TWO to true,
            Row.ONE to false,
        )
        canMoveBackward.forEach { (row, canMove) ->
            assertEquals(canMove, row.canMoveBackward())
        }
    }

    @Test
    fun givenRowWhenCanMoveForwardThenReturnTrueIfItIsNotFirstRow() {
        val canMoveForward = mapOf(
            Row.EIGHT to false,
            Row.SEVEN to true,
            Row.SIX to true,
            Row.FIVE to true,
            Row.FOUR to true,
            Row.THREE to true,
            Row.TWO to true,
            Row.ONE to true,
        )
        canMoveForward.forEach { (row, canMove) ->
            assertEquals(canMove, row.canMoveForward())
        }
    }

    @Test
    fun givenIntWhenMoveThenReturnResultRow() {
        assertEquals(Row.FOUR.move(2), Row.SIX)
        assertEquals(Row.EIGHT.move(-2), Row.SIX)
        assertEquals(Row.THREE.move(-2), Row.ONE)
    }
}