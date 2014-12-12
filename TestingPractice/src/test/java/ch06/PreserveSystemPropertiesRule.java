package test.java.ch06;

import java.util.Map;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class PreserveSystemPropertiesRule implements TestRule {

	public static final String KEY = "myKey";
	public static final String VALUE = "myValue";
	
	private Map<String, String> values;
	
	public void setValues(Map<String, String> values) {
		this.values = values;

		boolean validValues = false;
		if (values.containsKey(KEY)) {
			if (values.get(KEY).equals(VALUE)) {
				// we're good to go
				validValues = true;
			}
		}

		if (!validValues) {
			throw new IllegalArgumentException(
					"expected myKey=myValue to be contained in the value map");
		}
	}

	@Override
	public Statement apply(Statement base, Description description) {
		System.out.println("apply");
		return new PreserveStatement(base);
	}

	public class PreserveStatement extends Statement {

		private Statement base;
		
		public PreserveStatement(Statement base) {
			this.base = base;
		}
		
		@Override
		public void evaluate() throws Throwable {
			// before
			try {
				base.evaluate();
				if (values != null) values.put(KEY, VALUE);
			} finally {
				// after
				System.out.println("put values back");
			}
		}
		
	}
}
