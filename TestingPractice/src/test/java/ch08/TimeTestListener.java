package test.java.ch08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TimeTestListener extends TestWatcher {

	private long startTime;
	List<TestOutput> testOutput = new ArrayList<TestOutput>();
	TestOutput currentTest;

	@Override
	protected void starting(Description description) {
		currentTest = new TestOutput(description.getClassName(),
				description.getMethodName());
		startTime = System.currentTimeMillis();
	}

	@Override
	protected void succeeded(Description description) {
		currentTest.setResult("OK");
	}

	@Override
	protected void failed(Throwable e, Description description) {
		currentTest.setResult("FAIL");
	}

	@Override
	protected void finished(Description description) {
		currentTest.setExecutionLength(System.currentTimeMillis() - startTime);

		testOutput.add(currentTest);
	}

	public void done() {
		Collections.sort(testOutput);

		for (TestOutput result : testOutput) {
			System.out.println(result.getResult() + "\t" + result.getFullName()
					+ "\t" + result.getFormattedExecutionLength());
		}
	}

	private class TestOutput implements Comparable<TestOutput> {

		private String className;
		private String methodName;
		private Long executionLength;
		private String result;

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}

		public TestOutput(String className, String methodName) {
			this.className = className;
			this.methodName = methodName;
		}

		public String getClassName() {
			return className;
		}

		public String getMethodName() {
			return methodName;
		}

		public String getFullName() {
			return getClassName() + "." + getMethodName();
		}

		public Long getExecutionLength() {
			return executionLength;
		}

		public String getFormattedExecutionLength() {
			return String.format("%d:%d:%d",
					TimeUnit.MILLISECONDS.toMinutes(executionLength),
					TimeUnit.MILLISECONDS.toSeconds(executionLength),
					TimeUnit.MILLISECONDS.toMillis(executionLength));

		}

		public void setExecutionLength(Long executionLength) {
			this.executionLength = executionLength;
		}

		@Override
		public int compareTo(TestOutput o) {
			if (this.executionLength > o.getExecutionLength()) {
				return -1;
			} else if (this.executionLength < o.getExecutionLength()) {
				return 1;
			} else {
				return 0;
			}
		}

	}
}
