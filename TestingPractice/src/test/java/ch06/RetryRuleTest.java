package test.java.ch06;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import test.java.ch06.RetryTestRule.Retry;

public class RetryRuleTest {

	@Rule
	public RetryTestRule retryTestRule = new RetryTestRule();
	
	static int executionNumber = 0;
	
	@Test
	@Retry(times = 6)
	public void shouldBeReRun() {
		executionNumber++;
		System.out.println("execution: " + executionNumber);
		Assert.fail("failing: " + executionNumber);
	}
	
}
