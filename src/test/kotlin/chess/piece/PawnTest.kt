package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Column
import chess.square.Row
import chess.square.Square
import kotlin.test.Test
import kotlin.test.assertEquals

internal class PawnTest {

    @Test
    fun givenPawnInCornerSquareWhenMainMoveThenReturnAllFirstSquareForward() {
        val pawn = Pawn(Color.BLACK, Square(Column.A, Row.ONE))
        val mainMovement = MainMovement(
            forward = mutableListOf(Square(Column.A, Row.TWO)),
            upRightDiagonal = mutableListOf(Square(Column.B, Row.TWO))
        )
        val result: MainMovement = pawn.mainMove()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenPawnInCenterSquareWhenMainMoveThenReturnAllFirstSquareForward() {
        val pawn = Pawn(Color.BLACK, Square(Column.D, Row.FOUR))
        val mainMovement = MainMovement(
            forward = mutableListOf(Square(Column.D, Row.FIVE)),
            upLeftDiagonal = mutableListOf(Square(Column.C, Row.FIVE)),
            upRightDiagonal = mutableListOf(Square(Column.E, Row.FIVE))
        )
        val result: MainMovement = pawn.mainMove()
        assertEquals(mainMovement, result)
    }
}