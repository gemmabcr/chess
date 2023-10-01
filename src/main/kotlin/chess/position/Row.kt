package chess.position

enum class Row {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT;

    fun maxUpMovement(): Int = Row.EIGHT.ordinal - this.ordinal
    fun maxDownMovement(): Int = this.ordinal
    fun add(rowMove: Int): Row = entries[this.ordinal + rowMove]

    companion object {
        fun all() = arrayOf(ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT)
    }
}
