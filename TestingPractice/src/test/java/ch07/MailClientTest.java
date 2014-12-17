package test.java.ch07;

import static org.mockito.Mockito.*;
import main.java.ch07.Email;
import main.java.ch07.EmailServer;
import main.java.ch07.MailClient;

import org.junit.Before;
import org.junit.Test;

public class MailClientTest {

	MailClient mailClient;
	String validAddress = "test@test.com";
	String validTitle = "Title";
	String validBody = "body";

	@Before
	public void setup() {
		mailClient = spy(new MailClient());
	}

	@Test
	public void sendEmailShouldInvokeStaticMethod() {
		Email email = mock(Email.class);
		doReturn(email).when(mailClient).getEmail(validAddress, validTitle,
				validBody);

		mailClient.sendEmail(validAddress, validTitle, validBody);

		verify(mailClient).getEmail(validAddress, validTitle, validBody);
		verify(email).getAddress();
		verify(email).getTitle();
		verify(email).getBody();
	}

}
