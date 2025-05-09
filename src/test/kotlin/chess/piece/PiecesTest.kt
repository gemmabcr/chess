package chess.piece

import chess.Color
import chess.square.Column
import chess.square.Journey
import chess.square.Row
import chess.square.Square
import kotlin.test.Test
import kotlin.test.assertFalse

internal class PiecesTest {
    private val pieces = Pieces()
    private val blackPieces = pieces.color(Color.BLACK)

    @Test
    fun givenPieceDestinationWithNotInMainMovePieceWhenIsValidThenReturnFalse() {
        val piece = blackPieces.first { it is Pawn }
        assertFalse(pieces.isValid(Journey(Pair(piece.getPosition(), Square(Column.A, Row.FIVE)))))
    }
}
