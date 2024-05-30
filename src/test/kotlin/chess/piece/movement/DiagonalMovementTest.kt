package chess.piece.movement

import chess.square.Column
import chess.square.Row
import chess.square.Square
import kotlin.test.Test
import kotlin.test.assertEquals

internal class DiagonalMovementTest {

    @Test
    fun givenDiagonalMovementWithCornerSquareWhenPossibleMovementThenReturnOnlyOneDiagonal() {
        val movement = DiagonalMovement(Square(Column.A, Row.ONE))
        val mainMovement = MainMovement(
            forwardRight = mutableListOf(
                Square(Column.B, Row.TWO),
                Square(Column.C, Row.THREE),
                Square(Column.D, Row.FOUR),
                Square(Column.E, Row.FIVE),
                Square(Column.F, Row.SIX),
                Square(Column.G, Row.SEVEN),
                Square(Column.H, Row.EIGHT),
            ),
        )
        val result: MainMovement = movement.possibleMoves()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenDiagonalMovementWithFirstRowSquareWhenPossibleMovementThenReturnOnlyTwoDiagonals() {
        val movement = DiagonalMovement(Square(Column.E, Row.ONE))
        val mainMovement = MainMovement(
            forwardLeft = mutableListOf(
                Square(Column.A, Row.FIVE),
                Square(Column.B, Row.FOUR),
                Square(Column.C, Row.THREE),
                Square(Column.D, Row.TWO),
            ),
            forwardRight = mutableListOf(
                Square(Column.F, Row.TWO),
                Square(Column.G, Row.THREE),
                Square(Column.H, Row.FOUR),
            ),
        )
        val result: MainMovement = movement.possibleMoves()
        assertEquals(mainMovement, result)
    }

    @Test
    fun givenDiagonalMovementWithCenteredSquareWhenPossibleMovementThenReturnFourDiagonals() {
        val movement = DiagonalMovement(Square(Column.E, Row.FOUR))
        val mainMovement = MainMovement(
            forwardLeft = mutableListOf(
                Square(Column.A, Row.EIGHT),
                Square(Column.B, Row.SEVEN),
                Square(Column.C, Row.SIX),
                Square(Column.D, Row.FIVE),
            ),
            forwardRight = mutableListOf(
                Square(Column.F, Row.FIVE),
                Square(Column.G, Row.SIX),
                Square(Column.H, Row.SEVEN),
            ),
            backwardLeft = mutableListOf(
                Square(Column.B, Row.ONE),
                Square(Column.C, Row.TWO),
                Square(Column.D, Row.THREE),
            ),
            backwardRight = mutableListOf(
                Square(Column.F, Row.THREE),
                Square(Column.G, Row.TWO),
                Square(Column.H, Row.ONE),
            ),
        )
        val result: MainMovement = movement.possibleMoves()
        assertEquals(mainMovement, result)
    }
}