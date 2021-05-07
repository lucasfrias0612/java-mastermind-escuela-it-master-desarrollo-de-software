package app.views;

import app.utils.Console;

abstract class ConsoleView {
	protected final Console console;

	public ConsoleView() {
		this.console = Console.instance();
	}
}
