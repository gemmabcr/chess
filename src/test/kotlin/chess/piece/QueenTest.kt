package chess.piece

import chess.Color
import chess.piece.movement.MainMovement
import chess.square.Column
import chess.square.Row
import chess.square.Square
import kotlin.test.Test
import kotlin.test.assertEquals

internal class QueenTest {

    @Test
    fun givenQueenInCornerSquareWhenMainMoveThenReturnAllSquareLinesAround() {
        val queen = Queen(Color.BLACK, Square(Column.A, Row.ONE))
        val mainMovement = MainMovement(
            forward = mutableListOf(
                Square(Column.A, Row.TWO),
                Square(Column.A, Row.THREE),
                Square(Column.A, Row.FOUR),
                Square(Column.A, Row.FIVE),
                Square(Column.A, Row.SIX),
                Square(Column.A, Row.SEVEN),
                Square(Column.A, Row.EIGHT),
            ),
            upRightDiagonal = mutableListOf(
                Square(Column.B, Row.TWO),
                Square(Column.C, Row.THREE),
                Square(Column.D, Row.FOUR),
                Square(Column.E, Row.FIVE),
                Square(Column.F, Row.SIX),
                Square(Column.G, Row.SEVEN),
                Square(Column.H, Row.EIGHT),
            ),
            right = mutableListOf(
                Square(Column.B, Row.ONE),
                Square(Column.C, Row.ONE),
                Square(Column.D, Row.ONE),
                Square(Column.E, Row.ONE),
                Square(Column.F, Row.ONE),
                Square(Column.G, Row.ONE),
                Square(Column.H, Row.ONE)
            )
        )
        val result: MainMovement = queen.mainMove()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenQueenInCenterSquareWhenMainMoveThenReturnAllSquareLinesAround() {
        val queen = Queen(Color.BLACK, Square(Column.D, Row.FOUR))
        val mainMovement = MainMovement(
            forward = mutableListOf(
                Square(Column.D, Row.FIVE),
                Square(Column.D, Row.SIX),
                Square(Column.D, Row.SEVEN),
                Square(Column.D, Row.EIGHT),
            ),
            backward = mutableListOf(
                Square(Column.D, Row.ONE),
                Square(Column.D, Row.TWO),
                Square(Column.D, Row.THREE),
            ),
            right = mutableListOf(
                Square(Column.E, Row.FOUR),
                Square(Column.F, Row.FOUR),
                Square(Column.G, Row.FOUR),
                Square(Column.H, Row.FOUR),
            ),
            left = mutableListOf(
                Square(Column.A, Row.FOUR),
                Square(Column.B, Row.FOUR),
                Square(Column.C, Row.FOUR),
            ),
            upRightDiagonal = mutableListOf(
                Square(Column.E, Row.FIVE),
                Square(Column.F, Row.SIX),
                Square(Column.G, Row.SEVEN),
                Square(Column.H, Row.EIGHT),
            ),
            upLeftDiagonal = mutableListOf(
                Square(Column.A, Row.SEVEN),
                Square(Column.B, Row.SIX),
                Square(Column.C, Row.FIVE),
            ),
            downLeftDiagonal = mutableListOf(
                Square(Column.A, Row.ONE),
                Square(Column.B, Row.TWO),
                Square(Column.C, Row.THREE),
            ),
            downRightDiagonal = mutableListOf(
                Square(Column.E, Row.THREE),
                Square(Column.F, Row.TWO),
                Square(Column.G, Row.ONE),
            )
        )
        val result: MainMovement = queen.mainMove()
        assertEquals(mainMovement, result)
    }
}