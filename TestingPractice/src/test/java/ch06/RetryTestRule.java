package test.java.ch06;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RetryTestRule implements TestRule {

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.METHOD })
	public @interface Retry {

		int times();

	}

	@Override
	public Statement apply(final Statement base, Description description) {
		for (Annotation annotation : description.getAnnotations()) {
			if (annotation instanceof Retry) {
				
				final Retry rule = (Retry) annotation;
				
				return new Statement() {

					@Override
					public void evaluate() throws Throwable {
						retry(base, 1, rule.times());
					}
				};
			}
		}

		return base;
	}

	private void retry(final Statement base, int no, int ttl) throws Throwable {
		try {
			base.evaluate();
			return;
		} catch (AssertionError e) {
			if (no == ttl) return;

			retry(base, no + 1, ttl);
		}
	}

}
