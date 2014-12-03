package test.java.ch05.subscribers;

import static org.junit.Assert.assertEquals;
import main.java.ch05.subscribers.UserImpl;

import org.junit.Test;

public class UserTest {

	private final String PASSWORD = "password";
	
	@Test
	public void canGetPasswordAfterSet() {
		UserImpl user = new UserImpl();
		
		user.setPassword(PASSWORD);
		
		assertEquals(PASSWORD, user.getPassword());
	}
	
}
