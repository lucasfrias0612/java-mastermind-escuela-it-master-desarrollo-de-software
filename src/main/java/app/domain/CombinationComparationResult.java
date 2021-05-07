package app.domain;

import java.util.HashSet;
import java.util.Set;

public class CombinationComparationResult {
	private Set<Color> blacks;
	private Set<Color> whites;

	public CombinationComparationResult() {
		this.blacks = new HashSet<Color>();
		this.whites = new HashSet<Color>();
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

	public int countWhites() {
		return this.whites.size();
	}
}
