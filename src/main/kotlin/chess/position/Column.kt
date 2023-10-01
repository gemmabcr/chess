package chess.position

enum class Column {
    A, B, C, D, E, F, G, H;

    infix fun `is`(column: Column): Boolean = this == column
    fun maxRightMovement(): Int = Column.H.ordinal - this.ordinal
    fun maxLeftMovement(): Int = this.ordinal
    fun add(columnMove: Int): Column = entries[this.ordinal + columnMove]
    fun canMoveRight(): Boolean = this.ordinal < Column.H.ordinal
    fun canMoveLeft(): Boolean = this.ordinal > Column.A.ordinal

    companion object {
        fun all() = arrayOf(A, B, C, D, E, F, G, H)
    }
}