package chess.piece

import chess.Color
import chess.square.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class QueenTest {

    @Test
    fun givenQueenInCornerSquareWhenMainMoveThenReturnAllSquareLinesAround() {
        val queen = Queen(Color.BLACK, Square(Column.A, Row.ONE))
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
                    Direction.FORWARD_RIGHT, mutableListOf(
                        Square(Column.B, Row.TWO),
                        Square(Column.C, Row.THREE),
                        Square(Column.D, Row.FOUR),
                        Square(Column.E, Row.FIVE),
                        Square(Column.F, Row.SIX),
                        Square(Column.G, Row.SEVEN),
                        Square(Column.H, Row.EIGHT),
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
                        Square(Column.H, Row.ONE)
                    )
                ),
            )
        )
        assertEquals(mainMovement, queen.mainMove())
    }

    @Test
    fun givenQueenInCenterSquareWhenMainMoveThenReturnAllSquareLinesAround() {
        val queen = Queen(Color.BLACK, Square(Column.D, Row.FOUR))
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(
                    Direction.FORWARD, mutableListOf(
                        Square(Column.D, Row.FIVE),
                        Square(Column.D, Row.SIX),
                        Square(Column.D, Row.SEVEN),
                        Square(Column.D, Row.EIGHT),
                    )
                ),
                Pair(
                    Direction.BACKWARD, mutableListOf(
                        Square(Column.D, Row.ONE),
                        Square(Column.D, Row.TWO),
                        Square(Column.D, Row.THREE),
                    )
                ),
                Pair(
                    Direction.FORWARD_LEFT, mutableListOf(
                        Square(Column.A, Row.SEVEN),
                        Square(Column.B, Row.SIX),
                        Square(Column.C, Row.FIVE),
                    )
                ),
                Pair(
                    Direction.FORWARD_RIGHT, mutableListOf(
                        Square(Column.E, Row.FIVE),
                        Square(Column.F, Row.SIX),
                        Square(Column.G, Row.SEVEN),
                        Square(Column.H, Row.EIGHT),
                    )
                ),
                Pair(
                    Direction.RIGHT, mutableListOf(
                        Square(Column.E, Row.FOUR),
                        Square(Column.F, Row.FOUR),
                        Square(Column.G, Row.FOUR),
                        Square(Column.H, Row.FOUR),
                    )
                ),
                Pair(
                    Direction.LEFT, mutableListOf(
                        Square(Column.A, Row.FOUR),
                        Square(Column.B, Row.FOUR),
                        Square(Column.C, Row.FOUR),
                    )
                ),
                Pair(
                    Direction.BACKWARD_LEFT, mutableListOf(
                        Square(Column.A, Row.ONE),
                        Square(Column.B, Row.TWO),
                        Square(Column.C, Row.THREE),
                    )
                ),
                Pair(
                    Direction.BACKWARD_RIGHT, mutableListOf(
                        Square(Column.E, Row.THREE),
                        Square(Column.F, Row.TWO),
                        Square(Column.G, Row.ONE),
                    )
                ),
            )
        )
        assertEquals(mainMovement, queen.mainMove())
    }

    @Test
    fun givenDestinationWhenJourneyThenReturnAllSquaresInBetween() {
        val queen = Queen(Color.BLACK, Square(Column.G, Row.ONE))
        val journey = Journey(Pair(queen.getPosition(), Square(Column.A, Row.SEVEN)))
        val squaresBetween = listOf(
            Square(Column.F, Row.TWO),
            Square(Column.E, Row.THREE),
            Square(Column.D, Row.FOUR),
            Square(Column.C, Row.FIVE),
            Square(Column.B, Row.SIX),
        )

        assertEquals(squaresBetween, queen.journey(journey))
    }
}