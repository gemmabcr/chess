package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Column
import chess.square.Direction
import chess.square.Row
import chess.square.Square
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
        val result: MainMovement = bishop.mainMove()
        assertEquals(mainMovement, result)
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
        val result: MainMovement = bishop.mainMove()
        assertEquals(mainMovement, result)
    }
}