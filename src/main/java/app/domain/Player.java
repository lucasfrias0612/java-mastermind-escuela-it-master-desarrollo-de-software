package app.domain;

import app.utils.Message;
import app.utils.YesNoDialog;

public class Player {

	public Combination readProposedCombination() {
		Combination combination = new Combination();
		do {
			combination.read(Message.PROPOSE_A_COMBINATION);
		} while (!combination.isValid());
		return combination;
	}
	
	public boolean resumes() {
		return new YesNoDialog().read(Message.DO_YOU_WANT_RESUME);
	}

}
