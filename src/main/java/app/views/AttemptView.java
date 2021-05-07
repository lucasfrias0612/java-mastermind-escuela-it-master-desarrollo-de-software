package app.views;

import app.domain.Attempt;
import app.utils.Message;

public class AttemptView extends ConsoleView {
	private CombinationView proposedCombinationView;
	private CombinationComparationResultView comparationResultView;

	public AttemptView(Attempt attempt) {
		assert attempt != null;
		this.proposedCombinationView = new CombinationView(attempt.getProposedCombination());
		this.comparationResultView = new CombinationComparationResultView(attempt.getComparationResult());
	}

	public void show() {
		this.proposedCombinationView.show();
		console.write(Message.NEW_BLANK_SPACE + Message.RIGHT_ARROW + Message.NEW_BLANK_SPACE);
		this.comparationResultView.write();
	}

}
