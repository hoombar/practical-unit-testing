package test.java;

import main.java.ch06.OperatingSystem;

import org.fest.assertions.api.Assertions;

import test.java.ch06.OperatingSystemAssert;

public class AllAssertions extends Assertions {

	public static OperatingSystemAssert assertThat(OperatingSystem actual) {
		return new OperatingSystemAssert(actual);
	}
	
}
