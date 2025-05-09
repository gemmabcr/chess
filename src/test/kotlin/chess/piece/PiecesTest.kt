package chess.piece

import chess.Color
import chess.square.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class PiecesTest {
    private val pieces = Pieces()
    private val allPieces = pieces.allPieces()
    private val blackPieces = pieces.color(Color.BLACK)

    @Test
    fun givenCreatedPiecesWhenAllPiecesThenReturnAllPiecesInOriginalPosition() {
        val whitePieces = pieces.color(Color.WHITE)
        val blackMain = blackPieces.filter { it !is Pawn }
        val whiteMain = whitePieces.filter { it !is Pawn }
        val whitePawns = whitePieces.filterIsInstance<Pawn>()
        val blackPawns = blackPieces.filterIsInstance<Pawn>()

        assertEquals(allPieces.size, 32)
        assertEquals(pieces.color(Color.BLACK).size, 16)
        assertEquals(pieces.color(Color.WHITE).size, 16)
        assertTrue(blackPawns.all { isInPenultimateRow(it.getPosition()) })
        assertEquals(blackPawns.map { it.getPosition().column }.toSet().size, Column.all().size)
        assertTrue(blackMain.all { isInLastRow(it.getPosition()) })
        assertTrue(whitePawns.all { isInSecondRow(it.getPosition()) })
        assertEquals(whitePawns.map { it.getPosition().column }.toSet().size, Column.all().size)
        assertTrue(whiteMain.all { isInFirstRow(it.getPosition()) })
        assertTrue(allPieces.filterIsInstance<Rook>().all { isInFirstColumn(it.getPosition()) })
        assertTrue(allPieces.filterIsInstance<Knight>().all { isInSecondColumn(it.getPosition()) })
        assertTrue(allPieces.filterIsInstance<Bishop>().all { isInThirdColumn(it.getPosition()) })
        assertTrue(allPieces.filterIsInstance<Queen>().all { it.getPosition().column.`is`(Column.D) })
        assertTrue(allPieces.filterIsInstance<King>().all { it.getPosition().column.`is`(Column.E) })
    }

    @Test
    fun givenPieceDestinationWithNotInMainMovePieceWhenIsValidThenReturnFalse() {
        val piece = blackPieces.first { it is Pawn }
        assertFalse(pieces.isValid(Journey(Pair(piece.getPosition(), Square(Column.A, Row.FIVE)))))
    }

    private fun isInLastRow(position: Square) = position.row.`is`(Row.EIGHT)
    private fun isInPenultimateRow(position: Square) = position.row.`is`(Row.SEVEN)
    private fun isInSecondRow(position: Square) = position.row.`is`(Row.TWO)
    private fun isInFirstRow(position: Square) = position.row.`is`(Row.ONE)
    private fun isInFirstColumn(position: Square) =
        position.column.`is`(Column.A) || position.column.`is`(Column.H)

    private fun isInSecondColumn(position: Square) =
        position.column.`is`(Column.B) || position.column.`is`(Column.G)

    private fun isInThirdColumn(position: Square) =
        position.column.`is`(Column.C) || position.column.`is`(Column.F)
}