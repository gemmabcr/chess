package chess.square.direction

enum class Horizontal {
    RIGHT, LEFT;

    infix fun `is`(direction: Horizontal): Boolean = this == direction
}
}