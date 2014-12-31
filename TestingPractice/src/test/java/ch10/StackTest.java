package test.java.ch10;

import java.util.EmptyStackException;

import main.java.ch10.Stack;

import static org.fest.assertions.api.Assertions.assertThat;
import org.junit.Test;

public class StackTest {

	final String ANY_ITEM = "ANY_ITEM";
	final String SECOND_ITEM = "SECOND_ITEM";
	final String THIRD_ITEM = "THIRD_ITEM";
	
	Stack<String> stack = new Stack<String>();
	
	@Test
	public void canPushToStack() {
		assertThat(stack.push(ANY_ITEM)).isEqualTo(ANY_ITEM);
	}
	
	@Test
	public void canPopOffStack() {
		stack.push(ANY_ITEM);
		
		assertThat(stack.pop()).isEqualTo(ANY_ITEM);
	}
	
	@Test
	public void canAddTwoOfTheSameItem() {
		stack.push(ANY_ITEM);
		stack.push(ANY_ITEM);
		
		assertThat(stack.size()).isEqualTo(2);
		stack.pop();
		assertThat(stack.size()).isEqualTo(1);
	}
	
	@Test(expected = EmptyStackException.class)
	public void shouldThrowExWhenStackEmptyAndPopped() {
		stack.pop();
	}
	
	@Test(expected = EmptyStackException.class)
	public void shouldThrowExWhenStackEmptyAndPeeked() {
		stack.peek();
	}
	
	@Test(expected = EmptyStackException.class)
	public void shouldThrowExWhenStackPoppedToEmptyAndPeeked() {
		stack.push(ANY_ITEM);
		stack.pop();
		
		stack.peek();
	}

	@Test(expected = EmptyStackException.class)
	public void shouldThrowExWhenStackPoppedToEmptyAndPopped() {
		stack.push(ANY_ITEM);
		stack.pop();
		
		stack.pop();
	}

	@Test
	public void canPeekTopOfStack() {
		stack.push(ANY_ITEM);
		stack.push(SECOND_ITEM);
		
		assertThat(stack.peek()).isEqualTo(SECOND_ITEM);
		
		stack.pop();
		
		assertThat(stack.peek()).isEqualTo(ANY_ITEM);
	}
	
	@Test
	public void shouldRespectOrder() {
		stack.push(ANY_ITEM);
		stack.push(SECOND_ITEM);
		stack.push(THIRD_ITEM);
	}
	
	@Test
	public void stackShouldBeEmptyWhenCreated() {
		assertThat(stack.isEmpty()).isEqualTo(true);
	}
	
	@Test
	public void stackShouldNotBeEmptyWhenElementsAdded() {
		stack.push(ANY_ITEM);
		
		assertThat(stack.isEmpty()).isEqualTo(false);
	}
	
	@Test
	public void stackShouldBeEmptyAfterItemsRemoved() {
		stack.push(ANY_ITEM);
		assertThat(stack.isEmpty()).isEqualTo(false);
		stack.pop();
		assertThat(stack.isEmpty()).isEqualTo(true);
	}
	
	@Test
	public void stackShouldNotBeEmptyWhenOneElementRemaining() {
		stack.push(ANY_ITEM);
		stack.push(ANY_ITEM);
		stack.pop();
		assertThat(stack.isEmpty()).isEqualTo(false);
	}
}
