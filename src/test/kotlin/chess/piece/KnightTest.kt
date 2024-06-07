package chess.piece

import chess.Color
import chess.square.Column
import chess.square.Direction
import chess.square.Row
import chess.square.Square
import kotlin.test.Test
import kotlin.test.assertEquals

internal class KnightTest {

    @Test
    fun givenKnightInCornerSquareWhenMainMoveThenReturnTwoPossiblesMoves() {
        val knight = Knight(Color.BLACK, Square(Column.A, Row.ONE))
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(
                    Direction.FORWARD_RIGHT, mutableListOf(Square(Column.B, Row.THREE), Square(Column.C, Row.TWO))
                )
            ),
        )
        val result: MainMovement = knight.mainMove()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenKnightInCenterBoardWhenMainMoveThenReturnAllPossiblesMovementsAround() {
        val knight = Knight(Color.BLACK, Square(Column.D, Row.FOUR))
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(Direction.FORWARD_RIGHT, mutableListOf(Square(Column.E, Row.SIX), Square(Column.F, Row.FIVE))),
                Pair(Direction.FORWARD_LEFT, mutableListOf(Square(Column.B, Row.FIVE), Square(Column.C, Row.SIX))),
                Pair(Direction.BACKWARD_LEFT, mutableListOf(Square(Column.B, Row.THREE), Square(Column.C, Row.TWO))),
                Pair(Direction.BACKWARD_RIGHT, mutableListOf(Square(Column.E, Row.TWO), Square(Column.F, Row.THREE)))
            )
        )
        val result: MainMovement = knight.mainMove()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenDestinationWhenJourneyThenReturnEmptyList() {
        val knight = Knight(Color.BLACK, Square(Column.D, Row.FOUR))
        val pieceDestination = PieceDestination(knight, Square(Column.F, Row.FOUR))
        val journey = emptyList<Square>()

        assertEquals(journey, knight.journey(pieceDestination))
    }
}