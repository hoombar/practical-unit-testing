package test.java.ch06;

import main.java.ch06.OperatingSystem;
import static test.java.AllAssertions.assertThat;
import org.junit.Test;

public class OperatingSystemTest {

	private OperatingSystem os;
	
	@Test
	public void testUsingMatchers() {
		os = new OperatingSystem();
		os.setNbOfBits(128);
		os.setReleaseYear(2013);
		
		assertThat(os).is128Bit().wasReleasedIn(2013);
	}
	
}
