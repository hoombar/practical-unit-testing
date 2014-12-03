package test.java.ch05.subscribers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import main.java.ch05.subscribers.SecurityService;
import main.java.ch05.subscribers.UserDAO;
import main.java.ch05.subscribers.UserImpl;
import main.java.ch05.subscribers.UserServiceImpl;

import org.junit.Before;
import org.junit.Test;

public class UserServiceImplTest {

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
		try {
			service.assignPassword(user, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		verify(user).setPassword(MD5_PASSWORD);
	}
	
	@Test
	public void shouldUpdateDaoWhenPasswordSet() {
		try {
			service.assignPassword(user, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		verify(dao).updateUser(user);
	}
	
	@Test
	public void shouldBeAbleToSetMultipleTimesWithoutChanging() {
		user = new UserImpl();
		user.setPassword(MD5_PASSWORD);
		
		try {
			service.assignPassword(user, PASSWORD);
			service.assignPassword(user, PASSWORD);
			service.assignPassword(user, PASSWORD);
			service.assignPassword(user, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		assertEquals(MD5_PASSWORD, user.getPassword());
	}
}
