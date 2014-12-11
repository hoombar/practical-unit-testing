package main.java.ch06;

public class Hello {

	private TimeProvider timeProvider;
	
	public Hello(TimeProvider timeProvider) {
		this.timeProvider = timeProvider;
	}
	
	public String sayHello() {
		if (timeProvider.isMorning()) {
			return "Good morning!";
		} else if (timeProvider.isAfternoon()) {
			return "Good afternoon!";
		} else {
			return "Good evening!";
		}
	}

}
