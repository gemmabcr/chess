package chess

import chess.square.Row

enum class Color(val mainPieceRow: Row, val pawnsRow: Row) {
    BLACK(Row.EIGHT, Row.SEVEN),
    WHITE(Row.ONE, Row.TWO)
    ;

    fun opposite(): Color = when (this) {
        BLACK -> WHITE
        WHITE -> BLACK
    }
}
