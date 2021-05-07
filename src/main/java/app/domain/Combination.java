package app.domain;

import java.util.Arrays;
import java.util.List;

public class Combination {
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
		List<Color> validColors = Arrays.asList(Color.validValues());
		for (Color color : this.getColors()) {
			if (!validColors.contains(color)) {
				return false;
			}
		}
		return true;
	}

	public boolean contains(Color color) {
		for (int i = 0; i < this.getColors().length; i++) {
			if (this.getColors()[i].equals(color)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsAt(Color color, int position) {
		assert this.getColors() != null && this.getColors()[position] != null;
		return this.getColors()[position].equals(color);
	}

	public void setCombinationAsString(String combination) {
		assert combination != null && combination.length() == NUMBER_OF_COLORS;
		for (int i = 0; i < combination.length(); i++) {
			if (Color.exists(combination.charAt(i))) {
				this.colors[i] = Color.valueOf(combination.charAt(i));
			}
		}
	}

	protected Color[] getColors() {
		return this.colors;
	}

	public int size() {
		return this.colors.length;
	}

	public String toString() {
		String output = "";
		for (Color color : this.getColors()) {
			output += color.toString();
		}
		return output;
	}

}
