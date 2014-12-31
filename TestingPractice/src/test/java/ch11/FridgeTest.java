package test.java.ch11;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import main.java.ch11.Fridge;
import main.java.ch11.NoSuchItemException;

import org.junit.Test;

public class FridgeTest {

	@Test
	public void testFridge() {
		Fridge fridge = new Fridge();
		
		fridge.put("cheese");
		assertEquals(true, fridge.contains("cheese"));
		assertEquals(false, fridge.put("cheese"));
		assertEquals(true, fridge.contains("cheese"));
		
		assertEquals(false, fridge.contains("ham"));
		
		fridge.put("ham");
		assertEquals(true, fridge.contains("cheese"));
		assertEquals(true, fridge.contains("ham"));
		
		try {
			fridge.take("sausage");
			fail("There was no sausage in the fridge!");
		} catch (NoSuchItemException ex) {
			// ok
		}
	}
	
	@Test
	public void testPutTake() throws NoSuchItemException {
		Fridge fridge = new Fridge();
		List<String> food = new ArrayList<String>();
		food.add("yogurt");
		food.add("milk");
		food.add("eggs");
		for (String item : food) {
			fridge.put(item);
			assertEquals(true, fridge.contains(item));
			fridge.take(item);
			assertEquals(false, fridge.contains(item));
		}
		
		for (String item : food) {
			try {
				fridge.take(item);
				fail("There was no " + item + " in the fridge");
			} catch (NoSuchItemException ex) {
				assertEquals(true, ex.getMessage().contains(item));
			}
		}
	}
	
}
