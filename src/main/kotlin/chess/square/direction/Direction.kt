package chess.square.direction

enum class Direction {
    FORWARD, BACKWARD, RIGHT, LEFT, FORWARD_LEFT, FORWARD_RIGHT, BACKWARD_LEFT, BACKWARD_RIGHT;

    infix fun `is`(direction: Direction): Boolean = this == direction
}