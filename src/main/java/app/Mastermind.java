package app;

import app.domain.Board;
import app.domain.Player;

class Mastermind {
	private Player player;
	private Board board;

	public Mastermind() {
		this.player = new Player();
		this.board = new Board(this.player);
	}

	public void run() {
		do {
			board.reset();
			board.interact();
		} while (this.player.resumes());
	}

	public static void main(String[] args) {
		new Mastermind().run();
	}

}
