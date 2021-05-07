package app;

import app.domain.Board;
import app.views.BoardView;

class Mastermind {
	private Board board;
	private BoardView boardView;

	public Mastermind() {
		this.board = new Board();
		this.boardView = new BoardView(this.board);
	}

	public void start() {
		do {
			this.board.reset();
			this.boardView.showTitle();
			do {
				this.boardView.show();
				this.boardView.readProposedCombination();
			} while (!this.board.isGameOver());
			if (this.board.isThereWinner()) {
				this.boardView.showWinnerMessage();
			} else {
				this.boardView.show();
				this.boardView.showLoserMessage();
			}
		} while (this.boardView.isResumed());
	}

	public static void main(String[] args) {
		new Mastermind().start();
	}

}
