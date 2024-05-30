package chess.square

enum class Row {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT;

    fun maxForwardMovement(): Int = EIGHT.ordinal - this.ordinal
    fun maxBackwardMovement(): Int = this.ordinal
    fun move(rowMove: Int): Row = entries[this.ordinal + rowMove]
    fun canMoveForward(): Boolean = this.ordinal < EIGHT.ordinal
    fun canMoveBackward(): Boolean = this.ordinal > ONE.ordinal

    companion object {
        fun all() = arrayOf(ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT)
    }
}
