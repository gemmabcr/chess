package chess.square

class MovementController(
    private val direction: Direction,
    private val origin: Square
) {
    private fun column(): Column = origin.getColumn()
    private fun row(): Row = origin.getRow()

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

    fun canMove(): Boolean = when {
        direction `is` Direction.FORWARD -> canMoveForward()
        direction `is` Direction.LEFT -> canMoveLeft()
        direction `is` Direction.BACKWARD -> canMoveBackward()
        direction `is` Direction.RIGHT -> canMoveRight()
        direction `is` Direction.FORWARD_LEFT -> canMoveForward() && canMoveLeft()
        direction `is` Direction.BACKWARD_LEFT -> canMoveBackward() && canMoveLeft()
        direction `is` Direction.BACKWARD_RIGHT -> canMoveBackward() && canMoveRight()
        direction `is` Direction.FORWARD_RIGHT -> canMoveForward() && canMoveRight()
        else -> false
    }

    private fun canMoveForward(): Boolean = row().canMoveForward()
    private fun canMoveRight(): Boolean = column().canMoveRight()
    private fun canMoveBackward(): Boolean = row().canMoveBackward()
    private fun canMoveLeft(): Boolean = column().canMoveLeft()
}
