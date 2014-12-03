package test.java;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import main.java.StringUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class StringUtilsTest {

	public Object[] getBackwardStrings() {
		return $(
			$("abc", "cba"), 
			$("asdffdsa", "asdffdsa"),
			$("qwerty", "ytrewq")
		);
	}
	
	public Object[] getNonAlphaNumericChars() {
		return $(
			$("!@£$%^&*()", ")(*&^%$£@!"),
			$("! @ £ $ % ^ & * ( ) ", " ) ( * & ^ % $ £ @ !")
		);
	}

	@Test
	public void shouldHandleEmpty() {
		assertEquals("", StringUtils.reverse(""));
	}

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerEx() {
		StringUtils.reverse(null);
	}
	
	@Test
	@Parameters(method = "getBackwardStrings")
	public void shouldReverseString(String actual, String expected) {
		assertEquals(expected, StringUtils.reverse(actual));
	}
	
	public void shouldWorkOnSingleChar() {
		assertEquals("a", StringUtils.reverse("a"));
	}
	
	@Test
	@Parameters(method = "getNonAlphaNumericChars")
	public void shouldWorkOnNonAlphaNumericChars(String actual, String expected) {
		assertEquals(expected, StringUtils.reverse(actual));
	}
}
