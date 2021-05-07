package app.domain;

import java.util.Arrays;
import java.util.Random;

public enum Color {
	RED('r'), BLUE('b'), YELLOW('y'), GREEN('g'), ORANGE('o'), PURPLE('p'), NULL('X');

	private char initial;

	private Color(char initial) {
		this.initial = initial;
	}

	public char getInitial() {
		return this.initial;
	}

	public static Color random() {
		int index = new Random().nextInt(Color.validValues().length);
		return Color.validValues()[index];
	}

	public static boolean exists(char initial) {
		for (Color color : Color.values()) {
			if (color.getInitial() == initial) {
				return true;
			}
		}
		return false;
	}

	public static Color valueOf(char initial) {
		for (Color color : Color.values()) {
			if (color.getInitial() == initial) {
				return color;
			}
		}
		return null;
	}

	public static String validValuesAsString() {
		String result = "";
		for (Color color : Color.validValues()) {
			result += color.toString();
		}
		return result;
	}

	public static Color[] validValues() {
		return Arrays.stream(Color.values()).filter(color -> color != Color.NULL).toArray(Color[]::new);
	}
	
	@Override
	public String toString() {
		return ""+this.initial;
	}

}
