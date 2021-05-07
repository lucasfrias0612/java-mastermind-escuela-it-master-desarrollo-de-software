package app.views;

import app.domain.Color;
import app.domain.Combination;
import app.utils.Message;

public class ProposeCombinationView extends ConsoleView {

	public Combination readProposedCombination() {
		Combination proposedCombination = new Combination();
		do {
			this.console.write(Message.PROPOSE_A_COMBINATION);
			String input = this.console.readString();
			if (input.length() == proposedCombination.size()) {
				if (this.hasValidColors(input)) {
					proposedCombination.setCombinationAsString(input);
				} else {
					this.console.writeln(Message.WRONG_COLORS_THEY_MUST_BE + Color.validValuesAsString());
				}
			} else {
				this.console.writeln(Message.WRONG_COMBINATION_LENGTH);
			}
		} while (!proposedCombination.isValid());
		return proposedCombination;
	}

	private boolean hasValidColors(String combination) {
		for (int i = 0; i < combination.length(); i++) {
			if (!Color.exists(combination.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
