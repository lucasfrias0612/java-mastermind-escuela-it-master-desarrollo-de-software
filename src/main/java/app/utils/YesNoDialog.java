package app.utils;

public class YesNoDialog {

	public boolean read(String question) {
		Console console = Console.instance();
		console.write(question + " (y/n):");
		char response = console.readChar(question);
		return response=='y' || response=='Y';
	}

}
