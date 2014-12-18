package test.java.ch08;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;

public class ExampleTimeListenerTest {

	@Rule
	public volatile static TimeTestListener timeListener = new TimeTestListener();
	
	@Test
	public void tenMillis() throws InterruptedException {
		Thread.sleep(10);
	}
	
	@Test
	public void twentyMillis() throws InterruptedException {
		Thread.sleep(20);
	}
	
	
	@AfterClass
	public static void done() {
		timeListener.done();
	}
}
