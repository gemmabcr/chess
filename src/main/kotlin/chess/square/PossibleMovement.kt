package chess.square

class PossibleMovement(
    private val square: Square,
    private val directions: List<Direction>
) {
    fun toMainMovement(maxMove: Int? = null): MainMovement {
        val mainMovement = MainMovement(mutableMapOf())

        for (direction in directions) {
            val index = maxMove ?: MaxMovement(direction, square).total()
            val possibleMoves: MutableList<Square> = mutableListOf()
            if (square.canMove(direction)) {
                for (i in 1..index) {
                    possibleMoves.add(square.move(direction, i))
                }
            }
            possibleMoves.forEach { square -> mainMovement.add(direction, square) }
        }

        return mainMovement
    }
}