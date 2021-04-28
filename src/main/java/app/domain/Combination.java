package app.domain;

import java.util.Arrays;
import java.util.List;
import app.utils.Console;
import app.utils.Message;

class Combination {
	private Color[] colors;
	private final int NUMBER_OF_COLORS = 4;

	public Combination() {
		this.colors = new Color[NUMBER_OF_COLORS];
		this.nullFill();
	}

	private void nullFill() {
		for (int i = 0; i < this.getColors().length; i++) {
			this.getColors()[i] = Color.NULL;
		}
	}

	public boolean isValid() {
		return this.isComplete() && this.hasValidColors();
	}

	private boolean isComplete() {
		for (Color color : this.getColors()) {
			if (color == null) {
				return false;
			}
		}
		return true;
	}

	private boolean hasValidColors() {
		List<Color> validColors = Arrays.asList(Color.validValues());
		for (Color color : this.getColors()) {
			if (!validColors.contains(color)) {
				return false;
			}
		}
		return true;
	}

	public boolean contains(Color c) {
		for (int i = 0; i < this.getColors().length; i++) {
			if (this.getColors()[i].equals(c)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsAt(Color c, int position) {
		return this.getColors()[position].equals(c);
	}

	protected Color[] getColors() {
		return this.colors;
	}
	
	public void read(String title) {
		Console console = Console.instance();
		console.write(title);
		String input = console.readString();
		if (input.length() == this.getColors().length) {
			for (int i = 0; i < input.length(); i++) {
				if (Color.exists(input.charAt(i))) {
					this.getColors()[i] = Color.valueOf(input.charAt(i));
				} else {
					console.writeln(Message.WRONG_COLORS_THEY_MUST_BE + Color.validValuesAsString());
					return;
				}
			}
		} else {
			console.writeln(Message.WRONG_COMBINATION_LENGTH);
		}
	}

	public void write() {
		Console.instance().write(this.toString());
	}

	public String toString() {
		String output = "";
		for (Color color : this.getColors()) {
			output += color.toString();
		}
		return output;
	}

	public int size() {
		return this.colors.length;
	}

}
