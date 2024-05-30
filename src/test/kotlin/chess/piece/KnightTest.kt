package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Column
import chess.square.Row
import chess.square.Square
import kotlin.test.Test
import kotlin.test.assertEquals

internal class KnightTest {

    @Test
    fun givenKnightInCornerSquareWhenMainMoveThenReturnTwoPossiblesMoves() {
        val knight = Knight(Color.BLACK, Square(Column.A, Row.ONE))
        val mainMovement = MainMovement(
            forwardRight = mutableListOf(Square(Column.B, Row.THREE), Square(Column.C, Row.TWO)),
        )
        val result: MainMovement = knight.mainMove()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenKnightInCenterBoardWhenMainMoveThenReturnAllPossiblesMovementsAround() {
        val knight = Knight(Color.BLACK, Square(Column.D, Row.FOUR))
        val mainMovement = MainMovement(
            forwardRight = mutableListOf(Square(Column.E, Row.SIX), Square(Column.F, Row.FIVE)),
            forwardLeft = mutableListOf(Square(Column.B, Row.FIVE), Square(Column.C, Row.SIX)),
            backwardLeft = mutableListOf(Square(Column.B, Row.THREE), Square(Column.C, Row.TWO)),
            backwardRight = mutableListOf(Square(Column.E, Row.TWO), Square(Column.F, Row.THREE)),
        )
        val result: MainMovement = knight.mainMove()
        assertEquals(mainMovement, result)
    }
}