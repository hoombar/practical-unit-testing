package main.java.ch07;

public class MailClient {

	public void sendEmail(String address, String title, String body) {
		Email email = getEmail(address, title, body);
		EmailServer.sendEmail(email);
	}
	
	public Email getEmail(String address, String title, String body) {
		return new Email(address, title, body);
	}
	
}
