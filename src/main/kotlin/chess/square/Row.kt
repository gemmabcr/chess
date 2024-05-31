package chess.square

enum class Row {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT;

    fun maxForwardMovement(): Int = EIGHT.ordinal - this.ordinal

    fun maxBackwardMovement(): Int = this.ordinal

    fun canMoveForward(): Boolean = this != EIGHT

    fun canMoveBackward(): Boolean = this != ONE

    fun move(rowMove: Int): Row = entries[this.ordinal + rowMove]

    companion object {
        fun all() = entries
    }
}
