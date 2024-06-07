package chess.piece

import chess.Color
import chess.square.Column
import chess.square.Direction
import chess.square.Row
import chess.square.Square
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RookTest {

    @Test
    fun givenRookInCornerSquareWhenMainMoveThenReturnAllForwardAndOneSidedSquare() {
        val rook = Rook(Color.BLACK, Square(Column.A, Row.ONE))
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
                        Square(Column.A, Row.EIGHT)
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
                )
            )
        )
        val result: MainMovement = rook.mainMove()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenRookInCenterSquareWhenMainMoveThenReturnAllFourDirectionsStraightSquares() {
        val rook = Rook(Color.BLACK, Square(Column.D, Row.FOUR))
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(
                    Direction.FORWARD, mutableListOf(
                        Square(Column.D, Row.FIVE),
                        Square(Column.D, Row.SIX),
                        Square(Column.D, Row.SEVEN),
                        Square(Column.D, Row.EIGHT)
                    )
                ),
                Pair(
                    Direction.BACKWARD, mutableListOf(
                        Square(Column.D, Row.ONE),
                        Square(Column.D, Row.TWO),
                        Square(Column.D, Row.THREE)
                    )
                ),
                Pair(
                    Direction.LEFT, mutableListOf(
                        Square(Column.A, Row.FOUR),
                        Square(Column.B, Row.FOUR),
                        Square(Column.C, Row.FOUR)
                    )
                ),
                Pair(
                    Direction.RIGHT, mutableListOf(
                        Square(Column.E, Row.FOUR),
                        Square(Column.F, Row.FOUR),
                        Square(Column.G, Row.FOUR),
                        Square(Column.H, Row.FOUR)
                    )
                ),
            )
        )
        val result: MainMovement = rook.mainMove()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenDestinationWhenJourneyThenReturnAllSquaresInBetween() {
        val queen = Queen(Color.BLACK, Square(Column.G, Row.ONE))
        val pieceDestination = PieceDestination(queen, Square(Column.G, Row.SIX))
        val journey = listOf(
            Square(Column.G, Row.TWO),
            Square(Column.G, Row.THREE),
            Square(Column.G, Row.FOUR),
            Square(Column.G, Row.FIVE),
        )

        assertEquals(journey, queen.journey(pieceDestination))
    }
}