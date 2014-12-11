package test.java.ch06;

import main.java.ch06.OperatingSystem;

import org.fest.assertions.api.AbstractAssert;
import org.fest.assertions.api.Assertions;

public class OperatingSystemAssert extends
		AbstractAssert<OperatingSystemAssert, OperatingSystem> {

	public OperatingSystemAssert(OperatingSystem actual) {
		super(actual, OperatingSystemAssert.class);
	}

	public static OperatingSystemAssert assertThat(OperatingSystem actual) {
		return new OperatingSystemAssert(actual);
	}

	public OperatingSystemAssert is128Bit() {
		isNotNull();

		Assertions.assertThat(actual.getNbOfBits())
		.overridingErrorMessage("Should be <%d> but was <%d>", 128,
				actual.getNbOfBits()).isEqualTo(128);

		return this;
	}

	public OperatingSystemAssert wasReleasedIn(int year) {
		isNotNull();

		Assertions.assertThat(actual.getReleaseYear())
		.overridingErrorMessage("Expected <%d> but found <%d>", year,
				actual.getReleaseYear()).isEqualTo(year);

		return this;
	}
}
