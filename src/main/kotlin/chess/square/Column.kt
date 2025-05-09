package chess.square

enum class Column {
    A, B, C, D, E, F, G, H;

    infix fun `is`(column: Column): Boolean = this == column

    fun canMoveRight(): Boolean = this != H

    fun canMoveLeft(): Boolean = this != A

    fun maxRightMovement(): Int = H.ordinal - this.ordinal

    fun maxLeftMovement(): Int = this.ordinal

    fun move(columnMove: Int): Column = entries[this.ordinal + columnMove]

    companion object {
        fun all() = entries
    }
}