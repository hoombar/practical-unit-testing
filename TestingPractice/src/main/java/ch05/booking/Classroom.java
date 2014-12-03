package main.java.ch05.booking;

import java.util.Collection;
import java.util.HashSet;

import test.java.ch05.booking.Equipment;

public class Classroom {

	private String name;
	private int capacity;
	private int open;
	private int close;
	private int equipment;
	private Collection<Integer> bookings = new HashSet<Integer>();

	public Classroom(String name, int capacity, int open, int close,
			int equipment) {
		
		this.name = name;
		this.capacity = capacity;
		this.open = open;
		this.close = close;
		this.equipment = equipment;
	}

	public String getName() {
		return this.name;
	}

	public boolean isAvailableAt(int hour) {
		return !bookings.contains(hour);
	}

	public int getCapacity() {
		return this.capacity;
	}

	public boolean book(int hour) {
		if (bookings.contains(hour))
			return false;
		if (hour < open)
			return false;
		if (hour > close)
			return false;

		bookings.add(hour);
		return true;
	}

	public int getOpen() {
		return this.open;
	}

	public int getClose() {
		return this.close;
	}

	public boolean hasEquipment(int i) {
		int value = equipment | i;
		
		if ((value | equipment) == equipment) {
			return true;
		}
		
		return false;
	}

}
