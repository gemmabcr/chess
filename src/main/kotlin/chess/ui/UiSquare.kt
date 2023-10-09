package chess.ui

import chess.Color
import chess.piece.*
import chess.square.Square
import java.lang.Error

class UiSquare(
    var icon: UiIcon,
    val square: Square,
) {
    fun `is`(square: Square): Boolean = this.square.`is`(square)
    fun isRowIndex(index: Int): Boolean = this.square.isRowIndex(index)

    fun changeIcon(piece: Piece) {
        this.icon = getPieceIcon(piece)
    }

    private fun getPieceIcon(piece: Piece): UiIcon {
        when (piece) {
            is King -> return when (Color.BLACK) {
                piece.getColor() -> UiIcon.BLACK_KING
                else -> UiIcon.WHITE_KING
            }

            is Queen -> return when (Color.BLACK) {
                piece.getColor() -> UiIcon.BLACK_QUEEN
                else -> UiIcon.WHITE_QUEEN
            }

            is Bishop -> return when (Color.BLACK) {
                piece.getColor() -> UiIcon.BLACK_BISHOP
                else -> UiIcon.WHITE_BISHOP
            }

            is Knight -> return when (Color.BLACK) {
                piece.getColor() -> UiIcon.BLACK_KNIGHT
                else -> UiIcon.WHITE_KNIGHT
            }

            is Rook -> return when (Color.BLACK) {
                piece.getColor() -> UiIcon.BLACK_ROOK
                else -> UiIcon.WHITE_ROOK
            }

            is Pawn -> return when (Color.BLACK) {
                piece.getColor() -> UiIcon.BLACK_PAWN
                else -> UiIcon.WHITE_PAWN
            }

            else -> throw Error("Incorrect piece")
        }
    }
}
