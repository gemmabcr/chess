package chess

import chess.player.Player

class Turn(private val players: Pair<Player, Player>) {

    private var currentTurn: Int = 1

    fun activePlayer(): Player = when {
        currentTurn % 2 != 0 -> players.first
        else -> players.second
    }

    fun next() {
        currentTurn++
    }
}
