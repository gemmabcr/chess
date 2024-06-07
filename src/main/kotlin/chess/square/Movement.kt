package chess.square

class Movement(
    private val square: Square,
    private val directions: List<Direction>
) {
    fun possibleMoves(maxMove: Int? = null): MainMovement {
        val mainMovement = MainMovement(mutableMapOf())

        for (direction in directions) {
            squares(
                direction,
                maxMove ?: maxMovement(direction)
            ).forEach { square -> mainMovement.add(direction, square) }
        }

        return mainMovement
    }

    private fun maxMovement(direction: Direction): Int = when {
        direction `is` Direction.FORWARD -> square.maxMove(Direction.FORWARD)
        direction `is` Direction.LEFT -> square.maxMove(Direction.LEFT)
        direction `is` Direction.BACKWARD -> square.maxMove(Direction.BACKWARD)
        direction `is` Direction.RIGHT -> square.maxMove(Direction.RIGHT)
        direction `is` Direction.FORWARD_LEFT -> square.maxMove(Direction.FORWARD_LEFT)
        direction `is` Direction.BACKWARD_LEFT -> square.maxMove(Direction.BACKWARD_LEFT)
        direction `is` Direction.BACKWARD_RIGHT -> square.maxMove(Direction.BACKWARD_RIGHT)
        direction `is` Direction.FORWARD_RIGHT -> square.maxMove(Direction.FORWARD_RIGHT)
        else -> 0
    }

    private fun squares(direction: Direction, maxMove: Int): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()
        if (square.canMove(direction)) {
            for (i in 1..maxMove) {
                possibleMoves.add(square.move(direction, i))
            }
        }
        return possibleMoves
    }
}