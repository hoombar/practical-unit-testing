package main.java.ch10;

import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class Stack<E> {

	private List<E> items = new LinkedList<E>();
	
	public E push(E item) {
		items.add(item);
		
		return item;
	}

	public E pop() {
		if (items.size() == 0) {
			throw new EmptyStackException();
		}
		
		E item = items.get(items.size()-1);
		
		items.remove(items.size()-1);
		return item;
	}

	public int size() {
		return items.size();
	}

	public E peek() {
		if (items.size() == 0) {
			throw new EmptyStackException();
		}
		
		return items.get(items.size()-1);
	}

	public boolean isEmpty() {
		return items.size() == 0;
	}
	
}
