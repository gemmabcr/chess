package chess.square

enum class Column {
    A, B, C, D, E, F, G, H;

    infix fun `is`(column: Column): Boolean = this == column
    fun maxRightMovement(): Int = H.ordinal - this.ordinal
    fun maxLeftMovement(): Int = this.ordinal
    fun add(columnMove: Int): Column = entries[this.ordinal + columnMove]
    fun canMoveRight(): Boolean = this.ordinal < H.ordinal
    fun canMoveLeft(): Boolean = this.ordinal > A.ordinal

    companion object {
        fun all() = arrayOf(A, B, C, D, E, F, G, H)
    }
}