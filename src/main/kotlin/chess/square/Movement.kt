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
                maxMove ?: MaxMovement(direction, square).total()
            ).forEach { square -> mainMovement.add(direction, square) }
        }

        return mainMovement
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