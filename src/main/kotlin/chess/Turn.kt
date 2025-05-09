package chess

import chess.player.ComputerPlayer
import chess.player.Player
import chess.player.UserPlayer
import chess.ui.Ui

class Turn(ui: Ui) {
    private val players: List<Player> = listOf(
        UserPlayer(Color.WHITE, ui),
        ComputerPlayer(Color.BLACK)
    )
    private var activePlayer = players[0]
    private var currentTurn: Int = 1

    fun activePlayer(): Player = activePlayer

    fun next() {
        activePlayer = players.first { it != activePlayer }
        currentTurn++
    }
}
