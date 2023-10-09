package chess.piece.pieces

import chess.Color
import chess.ChessResult
import chess.piece.Piece
import chess.piece.movement.PieceDestination
import chess.square.Square

class Pieces {
    private val blackPieces: MutableList<Piece> = PieceSetOut.setUpBlack()
    private val whitePieces: MutableList<Piece> = PieceSetOut.setUpWhite()

    fun allPieces(): List<Piece> {
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

    fun hasResult(): Boolean = isCheck() || isCheckMate(Color.BLACK) || isCheckMate(Color.WHITE)

    fun isCheck(): Boolean = isCheckBy(Color.BLACK) || isCheckBy(Color.WHITE)

    private fun isCheckBy(kingColor: Color): Boolean {
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

    private fun isCheckMate(kingColor: Color): Boolean {
        val teamPieces = when (kingColor) {
            Color.WHITE -> whitePieces
            else -> blackPieces
        }
        val enemiesPieces = when (kingColor) {
            Color.WHITE -> blackPieces
            else -> whitePieces
        }
        val kingMovements = teamPieces.find { it.isKing() }!!.mainMove()
        val enemiesMovements: List<Square> = enemiesPieces.filter { it.isKing().not() }.flatMap { it.mainMove() }
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
        if (destinationHasPiece != null) if (!(destinationHasPiece.`is`(movement.piece.getColor()))) {
            this.remove(destinationHasPiece)
        }
    }

    private fun remove(piece: Piece) = when (piece.getColor()) {
        Color.WHITE -> whitePieces.remove(piece)
        else -> blackPieces.remove(piece)
    }
}