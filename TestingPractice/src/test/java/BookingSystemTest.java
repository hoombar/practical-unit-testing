package test.java;

import static org.junit.Assert.*;
import main.java.BookingSystem;

import org.junit.Before;
import org.junit.Test;

public class BookingSystemTest {

	private BookingSystem mBookingSystem = new BookingSystem();

	@Before
	public void setup() {
		mBookingSystem.addBooking(1);
		mBookingSystem.addBooking(3);
	}

	@Test
	public void shouldListBookedHours() {
		assertArrayEquals(new Object[] { 1, 3 }, mBookingSystem.getHours()
				.toArray());
	}

	@Test
	public void shouldBeValidHour() {
		int[] invalidHours = { -1, 24, -10, 30 };

		for (int hour : invalidHours) {
			assertFalse(mBookingSystem.addBooking(hour));
		}

		for (int i = 0; i <= 23; i++) {
			if (i != 1 && i != 3) {
				// 1 and 3 were preloaded, so make sure it doesn't fail because
				// of a double booking
				assertTrue(mBookingSystem.addBooking(i));
			}

		}

	}

	@Test
	public void shouldNotAllowDoubleBooking() {
		assertFalse(mBookingSystem.addBooking(1));
	}

}
