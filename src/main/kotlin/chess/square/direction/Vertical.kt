package chess.square.direction

enum class Vertical {
    FORWARD, BACKWARD;

    infix fun `is`(direction: Vertical): Boolean = this == direction
}