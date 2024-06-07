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
        return when (piece) {
            is King -> uiIcon(piece, UiIcon.WHITE_KING, UiIcon.BLACK_KING)
            is Queen -> uiIcon(piece, UiIcon.WHITE_QUEEN, UiIcon.BLACK_QUEEN)
            is Bishop -> uiIcon(piece, UiIcon.WHITE_BISHOP, UiIcon.BLACK_BISHOP)
            is Knight -> uiIcon(piece, UiIcon.WHITE_KNIGHT, UiIcon.BLACK_KNIGHT)
            is Rook -> uiIcon(piece, UiIcon.WHITE_ROOK, UiIcon.BLACK_ROOK)
            is Pawn -> uiIcon(piece, UiIcon.WHITE_PAWN, UiIcon.BLACK_PAWN)
            else -> throw Error("Incorrect piece")
        }
    }

    private fun uiIcon(piece: Piece, white: UiIcon, black: UiIcon): UiIcon {
        return when (piece.`is`(Color.BLACK)) {
            true -> black
            false -> white
        }
    }
}
