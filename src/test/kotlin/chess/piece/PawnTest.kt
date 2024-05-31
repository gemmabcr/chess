package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Column
import chess.square.Direction
import chess.square.Row
import chess.square.Square
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
        val result: MainMovement = pawn.mainMove()
        assertEquals(mainMovement, result)
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
        val result: MainMovement = pawn.mainMove()
        assertEquals(mainMovement, result)
    }
}