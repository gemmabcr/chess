package chess.square

enum class Direction {
    FORWARD, BACKWARD, RIGHT, LEFT, FORWARD_LEFT, FORWARD_RIGHT, BACKWARD_LEFT, BACKWARD_RIGHT;

    infix fun `is`(direction: Direction): Boolean = this == direction

    companion object {
        fun all(): List<Direction> = entries

        fun diagonals(): List<Direction> = listOf(FORWARD_LEFT, FORWARD_RIGHT, BACKWARD_LEFT, BACKWARD_RIGHT)

        fun straights(): List<Direction> = listOf(FORWARD, BACKWARD, LEFT, RIGHT)

        fun forwards(): List<Direction> = listOf(FORWARD, FORWARD_LEFT, FORWARD_RIGHT)
    }
}