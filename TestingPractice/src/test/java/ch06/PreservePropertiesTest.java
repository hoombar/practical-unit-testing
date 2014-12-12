package test.java.ch06;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class PreservePropertiesTest {

	@Rule
	public PreserveSystemPropertiesRule rule= new PreserveSystemPropertiesRule();;

	public static Map<String, String> values ;

	@Before
	public void setup() {
		if (values == null) {
			values = new HashMap<String, String>();
			values.put(PreserveSystemPropertiesRule.KEY,
					PreserveSystemPropertiesRule.VALUE);
			
			rule.setValues(values);
		}
	}

	@Test
	public void modifyValues() {
		values.put(PreserveSystemPropertiesRule.KEY,
				"change");
	}

	@Test
	public void shouldPreserveValue() {
		assertThat(values.get(PreserveSystemPropertiesRule.KEY)).isEqualTo(
				PreserveSystemPropertiesRule.VALUE);
	}
}
