package chess.piece.pieces

import chess.Color
import chess.ChessResult
import chess.piece.Piece
import chess.piece.movement.PieceDestination
import chess.square.Square

class Pieces {
    private val blackPieces: MutableList<Piece> = InitialPieces.setUp(Color.BLACK)
    private val whitePieces: MutableList<Piece> = InitialPieces.setUp(Color.WHITE)

    private fun allPieces(): List<Piece> {
        return blackPieces.plus(whitePieces)
    }

    fun color(color: Color): List<Piece> = when (color) {
        Color.BLACK -> blackPieces
        else -> whitePieces
    }

    fun isValid(movement: PieceDestination): Boolean {
        val correctMove = movement.piece.isValid(movement.destination)
        if (!correctMove) {
            return false
        }
        val journey = movement.piece.journey(movement.destination)
        return journey.find { square -> isPlenty(square) } == null
    }

    private fun isPlenty(square: Square): Boolean = allPieces().find { piece -> piece.`is`(square) } != null

    fun hasResult(): Boolean {
        return isCheck(Color.BLACK) || isCheck(Color.WHITE)
        // TODO: is check mate
    }

    private fun isCheck(kingColor: Color): Boolean {
        val teamPieces = when (kingColor) {
            Color.WHITE -> whitePieces
            else -> blackPieces
        }
        val enemiesPieces = when (kingColor) {
            Color.WHITE -> blackPieces
            else -> whitePieces
        }
        val kingPosition = teamPieces.find { it.isKing() }!!.getPosition()
        val enemiesMovements: List<Square> = enemiesPieces.filter { it.isKing().not() }.flatMap { it.mainMove() }
        return enemiesMovements.find { movement -> movement.`is`(kingPosition) } != null
    }

    fun result(): ChessResult {
        TODO("Not yet implemented")
    }
}