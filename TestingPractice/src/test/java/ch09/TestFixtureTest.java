package test.java.ch09;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFixtureTest {

	@BeforeClass
	public static void classSetup() {
		System.out.println("Before class");
	}

	@Before
	public void setup() {
		System.out.println("Before method");
	}
	
	@Test
	public void testMethodA() {
		System.out.println("method A");
	}
	
	@Test
	public void testMethodB() {
		System.out.println("method B");
	}
	
	@After
	public void tearDown() {
		System.out.println("After method");
	}

	@AfterClass
	public static void classTearDown() {
		System.out.println("After class");
	}

}
