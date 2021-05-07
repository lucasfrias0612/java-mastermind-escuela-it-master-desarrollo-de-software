package app.views;

import app.domain.CombinationComparationResult;
import app.utils.Message;

public class CombinationComparationResultView extends ConsoleView {
	private CombinationComparationResult comparationResult;

	public CombinationComparationResultView(CombinationComparationResult comparationResult) {
		assert comparationResult != null;
		this.comparationResult = comparationResult;
	}

	public void write() {
		this.console.write(this.comparationResult.countBlacks() + Message.NEW_BLANK_SPACE + Message.BLACKS
				+ Message.NEW_BLANK_SPACE + this.comparationResult.countWhites() + Message.NEW_BLANK_SPACE
				+ Message.WHITES);
	}

}
