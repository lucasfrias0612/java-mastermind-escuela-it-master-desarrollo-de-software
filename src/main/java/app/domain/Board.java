package app.domain;

import java.util.List;
import java.util.Stack;

public class Board {
	private SecretCombination secretCombination;
	private Stack<Attempt> attempts;
	private final int NUMBER_OF_ATTEMPS = 10;

	public Board() {
		this.secretCombination = new SecretCombination();
		this.attempts = new Stack<Attempt>();
	}

	public void reset() {
		this.secretCombination.randomFill();
		this.attempts.clear();
	}

	public boolean isGameOver() {
		assert !this.attempts.isEmpty();
		return this.attempts.size() == NUMBER_OF_ATTEMPS || this.attempts.peek().isWinner();
	}

	public boolean isThereWinner() {
		assert !this.attempts.isEmpty();
		return this.attempts.peek().isWinner();
	}

	public void playNewAttempt(Combination proposedCombination) {
		assert proposedCombination != null && this.attempts.size() != NUMBER_OF_ATTEMPS;
		this.attempts.add(new Attempt(this.secretCombination, proposedCombination));
	}

	public SecretCombination getSecretCombination() {
		return this.secretCombination;
	}

	public List<Attempt> getAttempts() {
		return this.attempts;
	}

	public int getAttemptsCount() {
		return this.attempts.size();
	}
}
