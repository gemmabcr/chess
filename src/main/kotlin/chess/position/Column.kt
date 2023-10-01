package chess.position

enum class Column {
    A, B, C, D, E, F, G, H;

    infix fun `is`(column: Column): Boolean = this == column

    companion object {
        fun all() = arrayOf(A, B, C, D, E, F, G, H)
    }
}