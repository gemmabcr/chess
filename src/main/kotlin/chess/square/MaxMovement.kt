package chess.square

class MaxMovement(
    private val direction: Direction,
    private val square: Square
) {
    fun total(): Int = when (direction) {
        Direction.FORWARD -> maxForwardMovement()
        Direction.LEFT -> maxLeftMovement()
        Direction.BACKWARD -> maxBackwardMovement()
        Direction.RIGHT -> maxRightMovement()
        Direction.FORWARD_LEFT -> lowerValue(maxForwardMovement(), maxLeftMovement())
        Direction.BACKWARD_LEFT -> lowerValue(maxBackwardMovement(), maxLeftMovement())
        Direction.BACKWARD_RIGHT -> lowerValue(maxBackwardMovement(), maxRightMovement())
        Direction.FORWARD_RIGHT -> lowerValue(maxForwardMovement(), maxRightMovement())
    }

    private fun maxForwardMovement(): Int = square.getRow().maxForwardMovement()
    private fun maxRightMovement(): Int = square.getColumn().maxRightMovement()
    private fun maxBackwardMovement(): Int = square.getRow().maxBackwardMovement()
    private fun maxLeftMovement(): Int = square.getColumn().maxLeftMovement()

    private fun lowerValue(firstValue: Int, lastValue: Int) = when {
        firstValue > lastValue -> lastValue
        else -> firstValue
    }
}
