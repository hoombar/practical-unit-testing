package main.java;

import java.util.regex.Pattern;

public class PasswordValidator {

	private static final int MIN_LENGTH = 8;

	public static boolean isValid(String string) {
		String password = string.trim();
		Pattern hasNumbers = Pattern.compile(".*[0-9].*");
		Pattern hasSymbols = Pattern.compile(".*[^a-z0-9 ].*", Pattern.CASE_INSENSITIVE);

		if (password.length() < MIN_LENGTH) {
			return false;
		}

		if (!hasSymbols.matcher(password).matches()) {
			return false;
		}

		if (!hasNumbers.matcher(password).matches()) {
			return false;
		}

		return true;
	}

}
