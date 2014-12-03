package main.java;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {

	private List<Integer> mHours = new ArrayList<Integer>();
	
	public boolean addBooking(int i) {
		if (!validate(i)) return false;
		
		mHours.add(i);
		
		return true;
	}

	public List<Integer> getHours() {
		return mHours;
	}
	
	private boolean validate(int hour) {
		if (mHours.contains(hour)) return false;
		if (hour < 0 || hour > 23) return false;
		
		return true;
	}

}
