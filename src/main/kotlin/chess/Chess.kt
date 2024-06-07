package chess

import chess.piece.Piece
import chess.piece.Pieces
import chess.player.Player
import chess.square.Column
import chess.square.Journey
import chess.square.Row
import chess.square.Square
import chess.ui.Ui

class Chess {
    private val ui: Ui = Ui()
    private val pieces: Pieces = Pieces()
    private val turn: Turn = Turn(ui)
    private val board: List<List<Square>> = createBoard()

    init {
        startGame()
    }

    private fun createBoard(): List<List<Square>> {
        return Row.all().map { row: Row ->
            Column.all().map { column: Column ->
                Square(column, row)
            }
        }
    }

    private fun startGame() {
        do {
            ui.print(board, pieces.allPieces())
            val player = turn.activePlayer()
            ui.print(player)
            validMove(player)
            if (pieces.isCheck()) {
                ui.print(pieces.result())
            }
            turn.next()
        } while (!pieces.hasResult())
        ui.print(pieces.result())
    }

    private fun validMove(player: Player) {
        do {
            val journey: Journey = player.pieceMovement(pieces.onlyCanMove(player.getColor()))
            val validMove: Boolean = pieces.isValid(journey)
            if (validMove) {
                val piece: Piece = pieces.allPieces().first { it.hasPosition(journey.origin()) }
                pieces.maybeRemoveEnemy(journey.destination(), piece.enemyColor())
                piece.move(journey.destination())
            } else {
                ui.invalidMove()
            }
        } while (!validMove)
    }
}
