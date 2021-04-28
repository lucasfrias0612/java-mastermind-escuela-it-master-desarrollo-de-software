package app.domain;

import java.util.HashSet;
import java.util.Set;

import app.utils.Console;
import app.utils.Message;

class CombinationComparationResult {
	private Set<Color> blacks;
	private Set<Color> whites;

	public CombinationComparationResult() {
		this.blacks = new HashSet<Color>();
		this.whites = new HashSet<Color>();
	}

	public void write() {
		Console.instance().write(this.toString());
	}

	public String toString() {
		return this.countBlacks() + Message.NEW_BLANK_SPACE + Message.BLACKS + Message.NEW_BLANK_SPACE
				+ this.getWhitesCount() + Message.NEW_BLANK_SPACE + Message.WHITES;
	}

	public void addBlacks(Color color) {
		this.blacks.add(color);
	}

	public void addWhites(Color color) {
		if (!this.blacks.contains(color)) {
			this.whites.add(color);
		}
	}

	public int countBlacks() {
		return this.blacks.size();
	}

	private int getWhitesCount() {
		return this.whites.size();
	}
}
