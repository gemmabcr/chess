package chess

import chess.piece.pieces.Pieces
import chess.player.Player
import chess.square.Column
import chess.square.Row
import chess.square.Square
import chess.ui.Ui

class Chess {
    private val ui: Ui = Ui()
    private val pieces: Pieces = Pieces()
    private val turn: Turn = Turn(ui, pieces)
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
        } while(!pieces.hasResult())
        ui.print(pieces.result())
    }

    private fun validMove(player: Player) {
        do {
            val movement = player.pieceMovement()
            val validMove = pieces.isValid(movement)
            pieces.move(movement)
            pieces.checkRemoveEnemy(movement)
            if (!validMove) {
                ui.invalidMove()
            }
        } while (!validMove)
    }
}
