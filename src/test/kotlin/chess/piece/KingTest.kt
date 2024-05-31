package chess.piece

import chess.Color
import chess.square.Column
import chess.square.Direction
import chess.square.Row
import chess.square.Square
import kotlin.test.Test
import kotlin.test.assertEquals

internal class KingTest {

    @Test
    fun givenKingInCornerSquareWhenMainMoveThenReturnAllFirstSquareAround() {
        val king = King(Color.BLACK, Square(Column.A, Row.ONE))
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(Direction.FORWARD_RIGHT, mutableListOf(Square(Column.B, Row.TWO))),
                Pair(Direction.RIGHT, mutableListOf(Square(Column.B, Row.ONE))),
                Pair(Direction.FORWARD, mutableListOf(Square(Column.A, Row.TWO)))
            ),
        )
        val result: MainMovement = king.mainMove()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenKingInCenterBoardWhenMainMoveThenReturnAllFirstSquareAround() {
        val king = King(Color.BLACK, Square(Column.D, Row.FOUR))
        val mainMovement = MainMovement(
            moves = mutableMapOf(
                Pair(Direction.BACKWARD, mutableListOf(Square(Column.D, Row.THREE))),
                Pair(Direction.FORWARD, mutableListOf(Square(Column.D, Row.FIVE))),
                Pair(Direction.LEFT,mutableListOf(Square(Column.C, Row.FOUR))),
                Pair(Direction.RIGHT, mutableListOf(Square(Column.E, Row.FOUR))),
                Pair(Direction.FORWARD_LEFT, mutableListOf(Square(Column.C, Row.FIVE))),
                Pair(Direction.BACKWARD_LEFT, mutableListOf(Square(Column.C, Row.THREE))),
                Pair(Direction.FORWARD_RIGHT, mutableListOf(Square(Column.E, Row.FIVE))),
                Pair(Direction.BACKWARD_RIGHT, mutableListOf(Square(Column.E, Row.THREE))),
            ),
        )

        val result: MainMovement = king.mainMove()
        assertEquals(mainMovement, result)
    }
}