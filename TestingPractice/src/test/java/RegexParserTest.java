package test.java;

import static org.junit.Assert.*;

import java.util.List;

import main.java.RegexParser;

import org.junit.Test;

public class RegexParserTest {

	@Test
	public void shouldNotFindAny() {
		String eval = "abc 12";
		List<Integer> result = RegexParser.parse(eval);
		
		assertNull(result);
	}
	
	@Test
	public void shouldFindOne() {
		String eval = "cdefg 345 12bb23";
		
		List<Integer> result = RegexParser.parse(eval);
		assertArrayEquals(new Object[] { 345 }, result.toArray());
	}
	
	@Test
	public void shouldFindTwo() {
		String eval = "cdefg 345 12bb23 678tt";
		
		List<Integer> result = RegexParser.parse(eval);
		assertArrayEquals(new Object[] { 345, 678 }, result.toArray());
	}
	
}
