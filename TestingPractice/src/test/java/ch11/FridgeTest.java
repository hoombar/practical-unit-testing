package test.java.ch11;

import static org.fest.assertions.api.Assertions.assertThat;
import main.java.ch11.Fridge;
import main.java.ch11.NoSuchItemException;

import org.junit.Test;

public class FridgeTest {

	Fridge fridge = new Fridge();
	final String ITEM_CHEESE = "cheese";
	final String ITEM_HAM = "ham";
	final String ITEM_SAUSAGE = "sausage";
	
	@Test
	public void fridgeShouldAllowNewItemAdded() {
		assertThat(fridge.put(ITEM_CHEESE)).isEqualTo(true);
	}
	
	@Test
	public void shouldNotAllowMoreThanOneOfSameItem() {
		fridge.put(ITEM_CHEESE);
		assertThat(fridge.put(ITEM_CHEESE)).isEqualTo(false);
	}
	
	@Test
	public void canAddMultipleItems() {
		assertThat(fridge.put(ITEM_CHEESE)).isEqualTo(true);
		assertThat(fridge.put(ITEM_HAM)).isEqualTo(true);
		assertThat(fridge.put(ITEM_SAUSAGE)).isEqualTo(true);
	}
	
	@Test
	public void fridgeShouldContainItemPutIn() {
		fridge.put(ITEM_CHEESE);
		assertThat(fridge.contains(ITEM_CHEESE)).isEqualTo(true);
	}
	
	@Test
	public void fridgeShouldNotContainItemsNotPutIn() {
		assertThat(fridge.contains(ITEM_HAM)).isEqualTo(false);
		fridge.put(ITEM_HAM);
		assertThat(fridge.contains(ITEM_CHEESE)).isEqualTo(false);
	}
	
	@Test
	public void checkContainsDoesNotRemoveItems() {
		fridge.put(ITEM_CHEESE);
		fridge.contains(ITEM_CHEESE);
		assertThat(fridge.contains(ITEM_CHEESE)).isEqualTo(true);
	}
	
	@Test
	public void canTakeItemInFridge() throws NoSuchItemException {
		fridge.put(ITEM_CHEESE);
		fridge.take(ITEM_CHEESE);
		assertThat(fridge.contains(ITEM_CHEESE)).isEqualTo(false);
	}
	
	@Test(expected = NoSuchItemException.class)
	public void fridgeShouldThrowExceptionWhenTakingInvalidItem() throws NoSuchItemException {
		fridge.take(ITEM_CHEESE);
	}
	
}
