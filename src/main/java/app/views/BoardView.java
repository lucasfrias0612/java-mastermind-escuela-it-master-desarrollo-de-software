package app.views;

import app.domain.Attempt;
import app.domain.Board;
import app.utils.Message;

public class BoardView extends ConsoleView {
	private SecretCombinationView secretCombinationView;
	private ProposeCombinationView proposeCombinationView;
	private ResumeView resumeView;
	private Board board;

	public BoardView(Board board) {
		assert board != null;
		this.board = board;
		this.secretCombinationView = new SecretCombinationView(this.board.getSecretCombination());
		this.proposeCombinationView = new ProposeCombinationView();
		this.resumeView = new ResumeView();
	}

	public void show() {
		this.console.writeln();
		this.console.writeln(this.board.getAttemptsCount() + Message.NEW_BLANK_SPACE + Message.ATTEMPS);
		this.secretCombinationView.show();
		this.console.writeln();
		this.showAttempts();
	}

	public void readProposedCombination() {
		this.board.playNewAttempt(this.proposeCombinationView.readProposedCombination());
	}

	private void showAttempts() {
		for (Attempt attempt : this.board.getAttempts()) {
			new AttemptView(attempt).show();
			this.console.writeln();
		}
	}

	public void showTitle() {
		this.console.writeln(Message.MASTERMIND_TITLE);
	}

	public void showWinnerMessage() {
		this.console.writeln(Message.YOU_HAVE_WON);
	}

	public void showLoserMessage() {
		this.console.writeln(Message.YOU_HAVE_LOST);
	}

	public boolean isResumed() {
		return this.resumeView.isResumed();
	}
}
