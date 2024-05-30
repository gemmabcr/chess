package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Column
import chess.square.Row
import chess.square.Square
import kotlin.test.Test
import kotlin.test.assertEquals

internal class KingTest {

    @Test
    fun givenKingInCornerSquareWhenMainMoveThenReturnAllFirstSquareAround() {
        val king = King(Color.BLACK, Square(Column.A, Row.ONE))
        val mainMovement = MainMovement(
            upRightDiagonal = mutableListOf(Square(Column.B, Row.TWO)),
            right = mutableListOf(Square(Column.B, Row.ONE)),
            forward = mutableListOf(Square(Column.A, Row.TWO)),
        )
        val result: MainMovement = king.mainMove()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenKingInCenterBoardWhenMainMoveThenReturnAllFirstSquareAround() {
        val king = King(Color.BLACK, Square(Column.D, Row.FOUR))
        val mainMovement = MainMovement(
            backward = mutableListOf(Square(Column.D, Row.THREE)),
            forward = mutableListOf(Square(Column.D, Row.FIVE)),
            left = mutableListOf(Square(Column.C, Row.FOUR)),
            right = mutableListOf(Square(Column.E, Row.FOUR)),
            upLeftDiagonal = mutableListOf(Square(Column.C, Row.FIVE)),
            downLeftDiagonal = mutableListOf(Square(Column.C, Row.THREE)),
            upRightDiagonal = mutableListOf(Square(Column.E, Row.FIVE)),
            downRightDiagonal = mutableListOf(Square(Column.E, Row.THREE)),
        )

        val result: MainMovement = king.mainMove()
        assertEquals(mainMovement, result)
    }
}