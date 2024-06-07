package chess.piece

import chess.Color
import chess.square.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class PawnTest {

    @Test
    fun givenPawnInCornerSquareWhenMainMoveThenReturnAllFirstSquareForward() {
        val pawn = Pawn(Color.BLACK, Square(Column.A, Row.ONE))
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(Direction.FORWARD, mutableListOf(Square(Column.A, Row.TWO))),
                Pair(Direction.FORWARD_RIGHT, mutableListOf(Square(Column.B, Row.TWO))),
            )
        )
        assertEquals(mainMovement, pawn.mainMove())
    }

    @Test
    fun givenPawnInCenterSquareWhenMainMoveThenReturnAllFirstSquareForward() {
        val pawn = Pawn(Color.BLACK, Square(Column.D, Row.FOUR))
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(Direction.FORWARD, mutableListOf(Square(Column.D, Row.FIVE))),
                Pair(Direction.FORWARD_RIGHT, mutableListOf(Square(Column.E, Row.FIVE))),
                Pair(Direction.FORWARD_LEFT, mutableListOf(Square(Column.C, Row.FIVE))),
            )
        )
        assertEquals(mainMovement, pawn.mainMove())
    }

    @Test
    fun givenDestinationWhenJourneyThenReturnEmptyList() {
        val pawn = Pawn(Color.BLACK, Square(Column.D, Row.FOUR))
        val journey = Journey(Pair(pawn.getPosition(), Square(Column.D, Row.SIX)))
        val squaresBetween = emptyList<Square>()

        assertEquals(squaresBetween, pawn.journey(journey))
    }
}