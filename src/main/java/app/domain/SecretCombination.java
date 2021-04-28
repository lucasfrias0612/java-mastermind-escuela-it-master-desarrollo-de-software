package app.domain;

import app.utils.Console;
import app.utils.Message;

class SecretCombination extends Combination {

	public SecretCombination() {
		super();
		this.randomFill();
	}

	private void randomFill() {
		int i = 0;
		while (i < this.getColors().length) {
			Color randomColor = Color.random();
			if (!this.contains(randomColor)) {
				this.getColors()[i] = randomColor;
				i++;
			}
		}
	}

	@Override
	public void write() {
		Console.instance().write(this.toString());
	}

	private String encode(String string) {
		String output = "";
		for (int i = 0; i < string.length(); i++) {
			output += Message.ASTERISK;
		}
		return output;
	}

}
