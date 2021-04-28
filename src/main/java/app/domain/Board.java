package app.domain;

import java.util.Stack;
import app.utils.Console;
import app.utils.Message;

public class Board {
	private Player player;
	private SecretCombination secretCombination;
	private Stack<Attempt> attemps;
	private final int NUMBER_OF_ATTEMPS = 10;

	public Board(Player player) {
		this.player = player;
		this.reset();
	}

	public void reset() {
		this.secretCombination = new SecretCombination();
		this.attemps = new Stack<Attempt>();
	}

	public void interact() {
		this.showTitle();
		do {
			this.show();
			this.attemps.add(new Attempt(this.secretCombination, this.player.readProposedCombination()));
		} while (!this.isGameOver());
		if (this.attemps.peek().isWinner()) {
			this.showWinnerMessage();
		} else {
			this.show();
			this.showLoserMessage();
		}
	}

	private void show() {
		Console.instance().writeln();
		this.showNumerOfAttepmts();
		this.secretCombination.write();
		Console.instance().writeln();
		this.showAttepmts();
	}

	private void showTitle() {
		Console.instance().writeln(Message.MASTERMIND_TITLE);
	}

	private void showNumerOfAttepmts() {
		Console.instance().writeln(this.attemps.size() + Message.NEW_BLANK_SPACE + Message.ATTEMPS);
	}

	private void showAttepmts() {
		for (Attempt attemp : this.attemps) {
			attemp.write();
			Console.instance().writeln();
		}
	}

	private boolean isGameOver() {
		assert !this.attemps.isEmpty();
		return this.attemps.size() == NUMBER_OF_ATTEMPS || this.attemps.peek().isWinner();
	}

	private void showWinnerMessage() {
		Console.instance().writeln(Message.YOU_HAVE_WON);
	}

	private void showLoserMessage() {
		Console.instance().writeln(Message.YOU_HAVE_LOST);
	}
}
