package main.java.ch05.subscribers;

import java.util.Date;

public class Logger {

	public void log(Message message) {
		log(new Date(), message);
	}
	
	public void log(Date date, Message message) {
		
	}

}
