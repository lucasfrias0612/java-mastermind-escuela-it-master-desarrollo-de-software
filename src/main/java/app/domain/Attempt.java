package app.domain;

import app.utils.Console;
import app.utils.Message;

public class Attempt {
	private Combination secretCombination;
	private Combination proposedCombination;
	private CombinationComparationResult comparationResult;

	public Attempt(Combination secretCombination, Combination proposedCombination) {
		this.secretCombination = secretCombination;
		this.proposedCombination = proposedCombination;
		this.comparationResult = this.getResult();
	}

	private CombinationComparationResult getResult() {
		CombinationComparationResult result = new CombinationComparationResult();
		for (int i = 0; i < this.secretCombination.getColors().length; i++) {
			if (proposedCombination.contains(this.secretCombination.getColors()[i])) {
				if (proposedCombination.containsAt(this.secretCombination.getColors()[i], i)) {
					result.addBlacks(this.secretCombination.getColors()[i]);
				} else {
					result.addWhites(this.secretCombination.getColors()[i]);
				}
			}
		}
		return result;
	}

	public boolean isWinner() {
		return this.comparationResult.countBlacks() == this.secretCombination.size();
	}

	public void write() {
		Console console = Console.instance();
		this.proposedCombination.write();
		console.write(Message.NEW_BLANK_SPACE + Message.RIGHT_ARROW + Message.NEW_BLANK_SPACE);
		this.comparationResult.write();
	}
}
