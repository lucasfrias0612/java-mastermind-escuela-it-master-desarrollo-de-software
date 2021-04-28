package app.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {
	public static Console console;

	public static Console instance() {
		if (console == null)
			console = new Console();
		return console;
	}

	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public String readString(String title) {
		String input = null;
		write(title);
		try {
			input = this.bufferedReader.readLine();
		} catch (Exception exception) {
		}
		return input;
	}

	public String readString() {
		return readString("");
	}

	public int readInt(String title) {
		int input = 0;
		boolean ok = false;
		while (true) {
			try {
				input = Integer.parseInt(readString(title));
				ok = true;
			} catch (Exception ex) {
				writeError("integer");
			}
			assert ok;
			if (ok)
				return input;
		}
	}

	public char readChar(String title) {
		char charValue = ' ';
		boolean ok = false;
		while (true) {
			String input = readString(title);
			if (input.length() != 1) {
				writeError("character");
			} else {
				charValue = input.charAt(0);
				ok = true;
			}
			assert ok;
			if (ok)
				return charValue;
		}
	}

	public void writeln() {
		System.out.println();
	}

	public void write(String string) {
		System.out.print(string);
	}

	public void write(int integer) {
		System.out.print(integer);
	}

	public void writeln(String string) {
		System.out.println(string);
	}

	public void writeln(int integer) {
		System.out.println(integer);
	}

	public void write(char character) {
		System.out.print(character);
	}

	public void writeError(String format) {
		System.out.println("FORMAT ERROR! Enter a " + format + " formatted value.");
	}
}
