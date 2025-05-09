package chess.piece

import chess.Color
import chess.square.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class PiecesSetOutTest {
    private val totalPieces = 32

    @Test
    fun givenWhitePieces_whenSetup_thenReturnAllPiecesInInitialPosition() {
        val pieces = PieceSetOut.setUp(Color.WHITE)

        val whitePieces = listOf(
            Rook::class to Row.ONE,
            Pawn::class to Row.TWO,
            Knight::class to Row.ONE,
            Pawn::class to Row.TWO,
            Bishop::class to Row.ONE,
            Pawn::class to Row.TWO,
            Queen::class to Row.ONE,
            Pawn::class to Row.TWO,
            King::class to Row.ONE,
            Pawn::class to Row.TWO,
            Bishop::class to Row.ONE,
            Pawn::class to Row.TWO,
            Knight::class to Row.ONE,
            Pawn::class to Row.TWO,
            Rook::class to Row.ONE,
            Pawn::class to Row.TWO,
        )

        whitePieces.forEachIndexed { index, pieceClass ->
            assertEquals(pieceClass.first, pieces[index]::class)
            assertEquals(pieceClass.second, pieces[index].getPosition().row)
        }
        assertEquals(totalPieces / 2, whitePieces.size)
        assertTrue(pieces.all { isInSecondRow(it.getPosition()) })
        assertEquals(pieces.map { it.getPosition().column }.toSet().size, Column.all().size)
        assertTrue(pieces.all { isInFirstRow(it.getPosition()) })
        commonPieces(pieces)
    }

    private fun isInSecondRow(position: Square) = position.row.`is`(Row.TWO)
    private fun isInFirstRow(position: Square) = position.row.`is`(Row.ONE)

    @Test
    fun givenBlackPieces_whenSetup_thenReturnAllPiecesInInitialPosition() {
        val pieces = PieceSetOut.setUp(Color.BLACK)

        val blackPieces = listOf(
            Rook::class to Row.EIGHT,
            Pawn::class to Row.SEVEN,
            Knight::class to Row.EIGHT,
            Pawn::class to Row.SEVEN,
            Bishop::class to Row.EIGHT,
            Pawn::class to Row.SEVEN,
            Queen::class to Row.EIGHT,
            Pawn::class to Row.SEVEN,
            King::class to Row.EIGHT,
            Pawn::class to Row.SEVEN,
            Bishop::class to Row.EIGHT,
            Pawn::class to Row.SEVEN,
            Knight::class to Row.EIGHT,
            Pawn::class to Row.SEVEN,
            Rook::class to Row.EIGHT,
            Pawn::class to Row.SEVEN,
        )

        blackPieces.forEachIndexed { index, pieceClass ->
            assertEquals(pieceClass.first, pieces[index]::class)
            assertEquals(pieceClass.second, pieces[index].getPosition().row)
        }
        assertEquals(totalPieces / 2, blackPieces.size)
        assertTrue(pieces.all { isInPenultimateRow(it.getPosition()) })
        assertEquals(pieces.map { it.getPosition().column }.toSet().size, Column.all().size)
        assertTrue(pieces.all { isInLastRow(it.getPosition()) })
        commonPieces(pieces)
    }

    private fun isInLastRow(position: Square) = position.row.`is`(Row.EIGHT)
    private fun isInPenultimateRow(position: Square) = position.row.`is`(Row.SEVEN)

    private fun commonPieces(pieces: List<Piece>) {
        assertTrue(pieces.filterIsInstance<Rook>().all { isInFirstColumn(it.getPosition()) })
        assertTrue(pieces.filterIsInstance<Knight>().all { isInSecondColumn(it.getPosition()) })
        assertTrue(pieces.filterIsInstance<Bishop>().all { isInThirdColumn(it.getPosition()) })
        assertTrue(pieces.filterIsInstance<Queen>().all { it.getPosition().column.`is`(Column.D) })
        assertTrue(pieces.filterIsInstance<King>().all { it.getPosition().column.`is`(Column.E) })
    }

    private fun isInFirstColumn(position: Square) =
        position.column.`is`(Column.A) || position.column.`is`(Column.H)

    private fun isInSecondColumn(position: Square) =
        position.column.`is`(Column.B) || position.column.`is`(Column.G)

    private fun isInThirdColumn(position: Square) =
        position.column.`is`(Column.C) || position.column.`is`(Column.F)
}
