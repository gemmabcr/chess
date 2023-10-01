package chess.piece

import chess.Color
import chess.square.Square

abstract class Piece(
    private val color: Color,
    private val square: Square
) {
    protected val rowsUp = square.maxUpMovement()
    protected val rowsDown = square.maxDownMovement()
    protected val columnsRight = square.maxRightMovement()
    protected val columnsLeft = square.maxLeftMovement()

    protected val canMoveUp = square.canMoveUp()
    protected val canMoveRight = square.canMoveRight()
    protected val canMoveDown = square.canMoveDown()
    protected val canMoveLeft = square.canMoveLeft()

    private val diagonalMovement: DiagonalMovement = DiagonalMovement(square)

    abstract fun mainMove(): List<Square>
    fun possibleDiagonalMoves(): List<Square> = diagonalMovement.possibleDiagonalMoves()
}
