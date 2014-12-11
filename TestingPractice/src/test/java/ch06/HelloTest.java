package test.java.ch06;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junitparams.JUnitParamsRunner;
import main.java.ch06.Hello;
import main.java.ch06.TimeProvider;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class HelloTest {

	TimeProvider timeProvider = mock(TimeProvider.class);
	Hello hello = new Hello(timeProvider);
	
	@Test
	public void shouldSayHelloInTheMorning() {
		when(timeProvider.isMorning()).thenReturn(true);
		
		assertThat(hello.sayHello()).isEqualTo("Good morning!");
	}
	
	@Test
	public void shouldSayHelloInTheAfternoon() {
		when(timeProvider.isAfternoon()).thenReturn(true);
		
		assertThat(hello.sayHello()).isEqualTo("Good afternoon!");
	}
}
