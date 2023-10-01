package chess.square

enum class Row {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT;

    fun maxUpMovement(): Int = EIGHT.ordinal - this.ordinal
    fun maxDownMovement(): Int = this.ordinal
    fun move(rowMove: Int): Row = entries[this.ordinal + rowMove]
    fun canMoveUp(): Boolean = this.ordinal < EIGHT.ordinal
    fun canMoveDown(): Boolean = this.ordinal > ONE.ordinal

    companion object {
        fun all() = arrayOf(ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT)
    }
}
