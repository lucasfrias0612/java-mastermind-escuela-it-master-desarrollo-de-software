package app.views;

import app.domain.Combination;

public class CombinationView extends ConsoleView {
	private Combination combination;

	public CombinationView(Combination combination) {
		super();
		this.combination = combination;
	}

	public void show() {
		this.console.write(this.getCombinationAsString());
	}

	protected String getCombinationAsString() {
		return this.combination.toString();
	}

}