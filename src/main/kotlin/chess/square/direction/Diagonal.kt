package chess.square.direction

enum class Diagonal {
    FORWARD_LEFT, FORWARD_RIGHT, BACKWARD_LEFT, BACKWARD_RIGHT;

    infix fun `is`(direction: Diagonal): Boolean = this == direction
}
