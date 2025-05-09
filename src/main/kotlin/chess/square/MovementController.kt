package chess.square

class MovementController(
    private val direction: Direction,
    private val origin: Square
) {
    private fun column(): Column = origin.column
    private fun row(): Row = origin.row

    fun withDirection(direction: Direction): MovementController = MovementController(direction, this.origin)

    fun maxMovement(): Int = when (direction) {
        Direction.FORWARD -> maxForwardMovement()
        Direction.LEFT -> maxLeftMovement()
        Direction.BACKWARD -> maxBackwardMovement()
        Direction.RIGHT -> maxRightMovement()
        Direction.FORWARD_LEFT -> lowerValue(maxForwardMovement(), maxLeftMovement())
        Direction.BACKWARD_LEFT -> lowerValue(maxBackwardMovement(), maxLeftMovement())
        Direction.BACKWARD_RIGHT -> lowerValue(maxBackwardMovement(), maxRightMovement())
        Direction.FORWARD_RIGHT -> lowerValue(maxForwardMovement(), maxRightMovement())
    }

    private fun maxForwardMovement(): Int = row().maxForwardMovement()
    private fun maxRightMovement(): Int = column().maxRightMovement()
    private fun maxBackwardMovement(): Int = row().maxBackwardMovement()
    private fun maxLeftMovement(): Int = column().maxLeftMovement()

    private fun lowerValue(firstValue: Int, lastValue: Int) = when {
        firstValue > lastValue -> lastValue
        else -> firstValue
    }

    fun canMove(): Boolean = when (direction) {
        Direction.FORWARD -> canMoveForward()
        Direction.LEFT -> canMoveLeft()
        Direction.BACKWARD -> canMoveBackward()
        Direction.RIGHT -> canMoveRight()
        Direction.FORWARD_LEFT -> canMoveForward() && canMoveLeft()
        Direction.BACKWARD_LEFT -> canMoveBackward() && canMoveLeft()
        Direction.BACKWARD_RIGHT -> canMoveBackward() && canMoveRight()
        Direction.FORWARD_RIGHT -> canMoveForward() && canMoveRight()
    }

    private fun canMoveForward(): Boolean = row().canMoveForward()
    private fun canMoveRight(): Boolean = column().canMoveRight()
    private fun canMoveBackward(): Boolean = row().canMoveBackward()
    private fun canMoveLeft(): Boolean = column().canMoveLeft()
}
