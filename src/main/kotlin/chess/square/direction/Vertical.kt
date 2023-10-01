package chess.square.direction

enum class Vertical {
    UP, DOWN;

    infix fun `is`(direction: Vertical): Boolean = this == direction
}