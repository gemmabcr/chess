package chess.piece

import chess.Color
import chess.square.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class BishopTest {

    @Test
    fun givenBishopInCornerSquareWhenMainMoveThenReturnAllSquaresRightDiagonal() {
        val bishop = Bishop(Color.BLACK, Square(Column.A, Row.ONE))
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
                        Square(Column.H, Row.EIGHT)
                    )
                )
            )
        )
        assertEquals(mainMovement, bishop.mainMove())
    }

    @Test
    fun givenBishopInCenterBoardWhenMainMoveThenReturnAllSquaresInAllSidesDiagonal() {
        val bishop = Bishop(Color.BLACK, Square(Column.D, Row.FOUR))
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(
                    Direction.FORWARD_RIGHT, mutableListOf(
                        Square(Column.E, Row.FIVE),
                        Square(Column.F, Row.SIX),
                        Square(Column.G, Row.SEVEN),
                        Square(Column.H, Row.EIGHT),
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
                    Direction.BACKWARD_RIGHT, mutableListOf(
                        Square(Column.E, Row.THREE),
                        Square(Column.F, Row.TWO),
                        Square(Column.G, Row.ONE),
                    )
                ),
                Pair(
                    Direction.BACKWARD_LEFT, mutableListOf(
                        Square(Column.A, Row.ONE),
                        Square(Column.B, Row.TWO),
                        Square(Column.C, Row.THREE),
                    )
                )
            )
        )
        assertEquals(mainMovement, bishop.mainMove())
    }

    @Test
    fun givenDestinationWhenJourneyThenReturnAllSquaresInBetween() {
        val bishop = Bishop(Color.BLACK, Square(Column.G, Row.ONE))
        val pieceDestination = PieceDestination(bishop, Square(Column.D, Row.FOUR))
        val journey = listOf(
            Square(Column.F, Row.TWO),
            Square(Column.E, Row.THREE),
        )

        assertEquals(journey, bishop.journey(pieceDestination))
    }

    @Test
    fun givenDestination2WhenJourneyThenReturnAllSquaresInBetween() {
        val bishop = Bishop(Color.BLACK, Square(Column.D, Row.FOUR))
        val pieceDestination = PieceDestination(bishop, Square(Column.G, Row.ONE))
        val journey = listOf(
            Square(Column.E, Row.THREE),
            Square(Column.F, Row.TWO),
        )

        assertEquals(journey, bishop.journey(pieceDestination))
    }
}