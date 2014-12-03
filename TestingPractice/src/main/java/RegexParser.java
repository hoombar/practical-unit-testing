package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexParser {

	public static List<Integer> parse(String eval) {
		Pattern numberMatch = Pattern.compile("[0-9]{3}");
		Matcher m = numberMatch.matcher(eval);
		
		List<Integer> result = new ArrayList<Integer>();
		
		while (m.find()) {
			result.add(Integer.parseInt(m.group()));
		}
		
		if (result.size() == 0) return null;
		
		return result;
	}

}
