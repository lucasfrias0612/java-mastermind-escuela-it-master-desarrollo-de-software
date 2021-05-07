package app.utils;

public class YesNoDialog {

	public boolean read(String question) {
		assert question != null && !question.isEmpty() && !question.isBlank();
		Console console = Console.instance();
		char response = console.readChar(question + " (y/n):");
		return response == 'y' || response == 'Y';
	}

}
