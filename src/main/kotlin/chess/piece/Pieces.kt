package chess.piece

import chess.Color
import chess.ChessResult
import chess.square.Journey
import chess.square.Square

class Pieces {
    private val pieces: Map<Color, MutableList<Piece>> = Color.entries.associateWith { PieceSetOut.setUp(it) }

    fun allPieces(): List<Piece> = pieces.values.flatten().toList()

    fun color(color: Color): List<Piece> = getTeamPieces(color)

    fun isValid(journey: Journey): Boolean {
        val piece: Piece = allPieces().first { it.hasPosition(journey.origin()) }
        if (piece.mainMove().notContains(journey.destination())) {
            return false
        }
        if (journey.squaresBetween().any { square -> isPlenty(square) }) {
            return false
        }
        val destinationHasPiece = allPieces().find { it.hasPosition(journey.destination()) }
        if (destinationHasPiece != null) {
            return !destinationHasPiece.hasSameColor(piece)
        }
        return true
    }

    private fun isPlenty(square: Square): Boolean = allPieces().find { piece -> piece.`is`(square) } != null

    fun hasResult(): Boolean = isCheckMate(Color.BLACK) || isCheckMate(Color.WHITE)

    fun isCheck(): Boolean = isCheckBy(Color.BLACK) || isCheckBy(Color.WHITE)

    private fun isCheckBy(kingColor: Color): Boolean {
        val teamPieces = getTeamPieces(kingColor)
        val enemiesPieces = getEnemiesPieces(kingColor)
        val king = teamPieces.find { it.isKing() }!!
        val enemiesMovements: List<Square> =
            enemiesPieces.filter { it.isKing().not() }.flatMap { it.mainMove().allSquares() }
        return enemiesMovements.find { king.hasPosition(it) } != null
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

    fun maybeRemoveEnemy(destination: Square, enemyColor: Color) {
        val maybePiece = this.allPieces().find { piece: Piece -> piece.`is`(destination) }
        if (maybePiece != null) {
            assert(maybePiece.`is`(enemyColor))
            remove(maybePiece, enemyColor)
        }
    }

    private fun remove(piece: Piece, enemyColor: Color) {
        pieces[enemyColor]!!.remove(piece)
    }

    fun onlyCanMove(color: Color): List<Piece> {
        // TODO: implement that
        return color(color).filter { it.canMove() }
    }
}