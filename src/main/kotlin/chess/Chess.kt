package chess

import chess.board.Board

class Chess {
    private val turn: Turn = Turn()
    private val board: Board = Board()

    init {
        startGame()
    }

    private fun startGame() {
        do {
            val player = turn.activePlayer()
            validMove(player)
            turn.next()
        } while(board.hasResult())
    }

    private fun validMove(player: Player) {
        do {
            val move = player.move()
            val validMove = board.isValid(move)
        } while (!validMove)
    }
}