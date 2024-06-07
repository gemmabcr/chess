package chess.piece

import chess.Color
import chess.ChessResult
import chess.square.Square

class Pieces {
    private val pieces: Map<Color, MutableList<Piece>> = Color.entries.associateWith { PieceSetOut.setUp(it) }

    fun allPieces(): List<Piece> = pieces.values.flatten().toList()

    fun color(color: Color): List<Piece> = getTeamPieces(color)

    fun isValid(movement: PieceDestination): Boolean {
        val correctMove = movement.piece.isValid(movement.destination)
        if (!correctMove) {
            return false
        }
        val journey = movement.piece.journey(movement)
        if (journey.find { square -> isPlenty(square) } != null) {
            return false
        }
        val destinationHasPiece = this.allPieces().find { piece: Piece -> piece.`is`(movement.destination) }
        if (destinationHasPiece != null) return when {
            destinationHasPiece.`is`(movement.piece.getColor()) -> false
            else -> true
        }
        return true
    }

    private fun isPlenty(square: Square): Boolean = allPieces().find { piece -> piece.`is`(square) } != null

    fun hasResult(): Boolean = isCheckMate(Color.BLACK) || isCheckMate(Color.WHITE)

    fun isCheck(): Boolean = isCheckBy(Color.BLACK) || isCheckBy(Color.WHITE)

    private fun isCheckBy(kingColor: Color): Boolean {
        val teamPieces = getTeamPieces(kingColor)
        val enemiesPieces = getEnemiesPieces(kingColor)
        val kingPosition = teamPieces.find { it.isKing() }!!.getPosition()
        val enemiesMovements: List<Square> =
            enemiesPieces.filter { it.isKing().not() }.flatMap { it.mainMove().allSquares() }
        return enemiesMovements.find { movement -> movement.`is`(kingPosition) } != null
    }

    private fun getEnemiesPieces(kingColor: Color) =
        pieces.filter { it.key.ordinal != kingColor.ordinal }.values.flatten()

    private fun getTeamPieces(kingColor: Color) = pieces[kingColor]!!.toList()

    private fun isCheckMate(kingColor: Color): Boolean {
        val teamPieces = getTeamPieces(kingColor)
        val enemiesPieces = getEnemiesPieces(kingColor)
        val kingMovements = teamPieces.find { it.isKing() }!!.mainMove().allSquares()
        val enemiesMovements: List<Square> =
            enemiesPieces.filter { it.isKing().not() }.flatMap { it.mainMove().allSquares() }
        return kingMovements.all { kingMovement -> enemiesMovements.any { it.`is`(kingMovement) } }
    }

    fun result(): ChessResult {
        if (isCheckBy(Color.WHITE) || isCheckBy(Color.BLACK)) {
            return ChessResult.CHECK
        }
        return ChessResult.CHECKMATE
    }

    fun checkRemoveEnemy(movement: PieceDestination) {
        val destinationHasPiece = this.allPieces().find { piece: Piece -> piece.`is`(movement.destination) }
        if (destinationHasPiece != null && !(destinationHasPiece.`is`(movement.piece.getColor()))) {
            this.remove(destinationHasPiece)
        }
    }

    private fun remove(piece: Piece) {
        pieces[piece.getColor()]!!.remove(piece)
    }

    fun move(movement: PieceDestination) {
        allPieces().find { piece -> piece.`is`(movement.piece.getPosition()) }!!.move(movement.destination)
    }
}