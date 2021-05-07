package app.views;

import app.domain.Combination;
import app.utils.Message;

public class SecretCombinationView extends CombinationView {

	public SecretCombinationView(Combination combination) {
		super(combination);
	}

	@Override
	public void show() {
		String output = "";
		for (int i = 0; i < this.getCombinationAsString().length(); i++) {
			output += Message.ASTERISK;
		}
		this.console.write(output);
	}

}
