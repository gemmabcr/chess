package chess

import chess.board.Board
import chess.piece.pieces.Pieces
import chess.player.ComputerPlayer
import chess.player.Player
import chess.player.UserPlayer
import chess.ui.Ui

class Chess {
    private val ui: Ui = Ui()
    private val pieces: Pieces = Pieces()
    private val players: Pair<Player, Player> = Pair(UserPlayer(Color.WHITE, ui), ComputerPlayer(Color.BLACK, pieces.color(Color.BLACK)))
    private val turn: Turn = Turn(players)
    private val board: Board = Board()

    init {
        startGame()
    }

    private fun startGame() {
        do {
            val player = turn.activePlayer()
            validMove(player)
            turn.next()
        } while(pieces.hasResult())
        ui.print(pieces.result())
    }

    private fun validMove(player: Player) {
        do {
            val movement = player.pieceMovement()
            val validMove = pieces.isValid(movement)
        } while (!validMove)
    }
}