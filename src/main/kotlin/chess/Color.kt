package chess

import chess.square.Row

enum class Color {
    BLACK, WHITE;

    fun rowMainPiece(): Row {
        if (this == WHITE) {
            return Row.ONE
        }
        return Row.EIGHT
    }

    fun rowPawns(): Row {
        if (this == WHITE) {
            return Row.TWO
        }
        return Row.SEVEN
    }

    fun opposite(): Color {
        return when (this) {
            BLACK -> WHITE
            WHITE -> BLACK
        }
    }
}
