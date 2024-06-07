package chess.square

import kotlin.test.Test
import kotlin.test.assertEquals

internal class MovementTest {

    @Test
    fun givenMovementWithCornerSquareAndDiagonalsWhenPossibleMovesThenReturnOnlyOneDiagonal() {
        val movement = Movement(Square(Column.A, Row.ONE), Direction.diagonals())
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(
                    Direction.FORWARD_RIGHT, mutableListOf(
                        Square(Column.B, Row.TWO),
                        Square(Column.C, Row.THREE),
                        Square(Column.D, Row.FOUR),
                        Square(Column.E, Row.FIVE),
                        Square(Column.F, Row.SIX),
                        Square(Column.G, Row.SEVEN),
                        Square(Column.H, Row.EIGHT),
                    )
                )
            )
        )
        val result: MainMovement = movement.possibleMoves()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenMovementWithFirstRowSquareAndDiagonalsWhenPossibleMovesThenReturnOnlyTwoDiagonals() {
        val movement = Movement(Square(Column.E, Row.ONE), Direction.diagonals())
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(
                    Direction.FORWARD_RIGHT, mutableListOf(
                        Square(Column.F, Row.TWO),
                        Square(Column.G, Row.THREE),
                        Square(Column.H, Row.FOUR),
                    )
                ),
                Pair(
                    Direction.FORWARD_LEFT, mutableListOf(
                        Square(Column.A, Row.FIVE),
                        Square(Column.B, Row.FOUR),
                        Square(Column.C, Row.THREE),
                        Square(Column.D, Row.TWO),
                    )
                )
            )
        )
        val result: MainMovement = movement.possibleMoves()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenMovementWithCenteredAndDiagonalsSquareWhenPossibleMovesThenReturnFourDiagonals() {
        val movement = Movement(Square(Column.E, Row.FOUR), Direction.diagonals())
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(
                    Direction.FORWARD_RIGHT, mutableListOf(
                        Square(Column.F, Row.FIVE),
                        Square(Column.G, Row.SIX),
                        Square(Column.H, Row.SEVEN),
                    )
                ),
                Pair(
                    Direction.FORWARD_LEFT, mutableListOf(
                        Square(Column.A, Row.EIGHT),
                        Square(Column.B, Row.SEVEN),
                        Square(Column.C, Row.SIX),
                        Square(Column.D, Row.FIVE),
                    )
                ),
                Pair(
                    Direction.BACKWARD_LEFT, mutableListOf(
                        Square(Column.B, Row.ONE),
                        Square(Column.C, Row.TWO),
                        Square(Column.D, Row.THREE),
                    )
                ),
                Pair(
                    Direction.BACKWARD_RIGHT, mutableListOf(
                        Square(Column.F, Row.THREE),
                        Square(Column.G, Row.TWO),
                        Square(Column.H, Row.ONE),
                    )
                )
            )
        )
        val result: MainMovement = movement.possibleMoves()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenMovementWithCornerSquareAndStraightsWhenPossibleMovesThenReturnOnlyTwoStraights() {
        val movement = Movement(Square(Column.A, Row.ONE), Direction.straights())
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(
                    Direction.FORWARD, mutableListOf(
                        Square(Column.A, Row.TWO),
                        Square(Column.A, Row.THREE),
                        Square(Column.A, Row.FOUR),
                        Square(Column.A, Row.FIVE),
                        Square(Column.A, Row.SIX),
                        Square(Column.A, Row.SEVEN),
                        Square(Column.A, Row.EIGHT),
                    )
                ),
                Pair(
                    Direction.RIGHT, mutableListOf(
                        Square(Column.B, Row.ONE),
                        Square(Column.C, Row.ONE),
                        Square(Column.D, Row.ONE),
                        Square(Column.E, Row.ONE),
                        Square(Column.F, Row.ONE),
                        Square(Column.G, Row.ONE),
                        Square(Column.H, Row.ONE),
                    )
                )
            )
        )
        val result: MainMovement = movement.possibleMoves()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenMovementWithFirstRowSquareAndStraightsWhenPossibleMovesThenReturnOnlyThreeStraights() {
        val movement = Movement(Square(Column.E, Row.ONE), Direction.straights())
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(
                    Direction.FORWARD, mutableListOf(
                        Square(Column.E, Row.TWO),
                        Square(Column.E, Row.THREE),
                        Square(Column.E, Row.FOUR),
                        Square(Column.E, Row.FIVE),
                        Square(Column.E, Row.SIX),
                        Square(Column.E, Row.SEVEN),
                        Square(Column.E, Row.EIGHT),
                    )
                ),
                Pair(
                    Direction.LEFT, mutableListOf(
                        Square(Column.A, Row.ONE),
                        Square(Column.B, Row.ONE),
                        Square(Column.C, Row.ONE),
                        Square(Column.D, Row.ONE),
                    )
                ),
                Pair(
                    Direction.RIGHT, mutableListOf(
                        Square(Column.F, Row.ONE),
                        Square(Column.G, Row.ONE),
                        Square(Column.H, Row.ONE),
                    )
                )
            )
        )
        val result: MainMovement = movement.possibleMoves()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenMovementWithCenteredSquareAndStraightsWhenPossibleMovesThenReturnAllStraights() {
        val movement = Movement(Square(Column.E, Row.FOUR), Direction.straights())
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(
                    Direction.FORWARD, mutableListOf(
                        Square(Column.E, Row.FIVE),
                        Square(Column.E, Row.SIX),
                        Square(Column.E, Row.SEVEN),
                        Square(Column.E, Row.EIGHT),
                    )
                ),
                Pair(
                    Direction.BACKWARD, mutableListOf(
                        Square(Column.E, Row.ONE),
                        Square(Column.E, Row.TWO),
                        Square(Column.E, Row.THREE),
                    )
                ),
                Pair(
                    Direction.LEFT, mutableListOf(
                        Square(Column.A, Row.FOUR),
                        Square(Column.B, Row.FOUR),
                        Square(Column.C, Row.FOUR),
                        Square(Column.D, Row.FOUR),
                    )
                ),
                Pair(
                    Direction.RIGHT, mutableListOf(
                        Square(Column.F, Row.FOUR),
                        Square(Column.G, Row.FOUR),
                        Square(Column.H, Row.FOUR),
                    )
                )
            )
        )
        val result: MainMovement = movement.possibleMoves()
        assertEquals(mainMovement, result)
    }
}