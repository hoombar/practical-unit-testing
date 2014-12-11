package main.java.ch06;

import java.util.Calendar;

public class TimeProvider {

	private Calendar calendar;
	
	public Calendar getTime() {
		if (this.calendar == null) {
			this.calendar = Calendar.getInstance();
		}
		
		return this.calendar;
	}
	
	public void load(Calendar newCal) {
		this.calendar = newCal;
	}

	public boolean isMorning() {
		int hour = getTime().get(Calendar.HOUR_OF_DAY);
		
		return hour >= 0 && hour <= 11;
	}
	
	public boolean isAfternoon() {
		int hour = getTime().get(Calendar.HOUR_OF_DAY);
		
		return hour >= 12 && hour <= 17;
	}
	
	public boolean isEvening() {
		int hour = getTime().get(Calendar.HOUR_OF_DAY);
		
		return hour >= 18 && hour < 24;
	}
	
}
