package test.java.ch06;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static com.googlecode.catchexception.CatchException.*;

import main.java.ch05.subscribers.SecurityService;
import main.java.ch05.subscribers.UserDAO;
import main.java.ch05.subscribers.UserImpl;
import main.java.ch05.subscribers.UserServiceImpl;

import org.junit.Before;
import org.junit.Test;

public class UserServiceImplBetterTest {

	private UserDAO dao = mock(UserDAO.class);
	private SecurityService security = mock(SecurityService.class);
	private UserServiceImpl service = new UserServiceImpl(dao, security);
	private UserImpl user = mock(UserImpl.class);
	
	private final String PASSWORD = "password";
	private final String MD5_PASSWORD = "md5_password";

	@Before
	public void setup() {
		when(security.md5(PASSWORD)).thenReturn(MD5_PASSWORD);
		when(user.getPassword()).thenReturn(PASSWORD);
	}
	
	@Test
	public void shouldSetUserPassword() {
		catchException(service).assignPassword(user, PASSWORD);
		assertNull(caughtException());
		
		verify(user).setPassword(MD5_PASSWORD);
	}
	
	@Test
	public void shouldUpdateDaoWhenPasswordSet() {
		catchException(service).assignPassword(user, PASSWORD);
		assertNull(caughtException());
		
		verify(dao).updateUser(user);
	}
	
	@Test
	public void shouldBeAbleToSetMultipleTimesWithoutChanging() {
		user = new UserImpl();
		user.setPassword(MD5_PASSWORD);

		for (int i = 0; i < 5; i++) {
			catchException(service).assignPassword(user, PASSWORD);
			assertNull(caughtException());
		}
			
		assertEquals(MD5_PASSWORD, user.getPassword());
	}
}
