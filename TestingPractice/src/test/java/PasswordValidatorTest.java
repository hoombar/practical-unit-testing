package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import main.java.PasswordValidator;

import org.junit.Test;

public class PasswordValidatorTest {

	String number = "1";
	String symbol = "&";
	
	@Test
	public void shouldNotAcceptLessThanMinChars() {
		String fiveChars = "abcde";
		String sevenChars = fiveChars + number + symbol;
		assertFalse(PasswordValidator.isValid(sevenChars));
		
		String blank = "";
		assertFalse(PasswordValidator.isValid(blank));
		
		String twoChars = "$4";
		assertFalse(PasswordValidator.isValid(twoChars));
	}
	
	@Test
	public void shouldNotContainWhitespace() {
		String invalidWithPadding1 = "    word";
		String invalidWithPadding2 = "pass    ";
		
		assertFalse(PasswordValidator.isValid(invalidWithPadding1));
		assertFalse(PasswordValidator.isValid(invalidWithPadding2));
	}
	
	@Test
	public void specialCharsCanBeAnywhere() {
		String validWithSymbol = "%p4$word";
		assertTrue(PasswordValidator.isValid(validWithSymbol));
		
		String validWithSymbol2 = "ap4$wor%";
		assertTrue(PasswordValidator.isValid(validWithSymbol2));
		
		String validWithNumber = "1l33td**d";
		assertTrue(PasswordValidator.isValid(validWithNumber));
		
		String validWithNumber2= "l33td**d232";
		assertTrue(PasswordValidator.isValid(validWithNumber2));
		
	}
	
	@Test
	public void shouldContainSymbol() {
		String validWithSymbol = "p4$$word";
		assertTrue(PasswordValidator.isValid(validWithSymbol));
		
		String validExceptForMissingSymbol = "p4ssword";
		assertFalse(PasswordValidator.isValid(validExceptForMissingSymbol));
	}
	
	@Test
	public void shouldContainNumber() {
		String validWithNumber = "l33td**d";
		assertTrue(PasswordValidator.isValid(validWithNumber));
		
		String validExceptForMissingNumber = "leetd**d";
		assertFalse(PasswordValidator.isValid(validExceptForMissingNumber));
	}
	
	@Test
	public void shouldBeValid() {
		String password = "password" + number + symbol;
		
		assertTrue(PasswordValidator.isValid(password));
	}
}
