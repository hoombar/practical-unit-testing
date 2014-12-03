package test.java.ch05.booking;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import main.java.ch05.booking.Classroom;

import org.junit.Test;

public class ClassroomTest {

	private final String A1_NAME = "A1";
	private final String B1_NAME = "B1";
	private final String C1_NAME = "C1";
	private final int A1_CAPACITY = 20;
	private final int B1_CAPACITY = 40;
	private final int C1_CAPACITY = 60;
	private final int CLASSROOM_OPEN = 9;
	private final int CLASSROOM_CLOSE = 17;

	private Classroom classroomA1 = new Classroom(A1_NAME, A1_CAPACITY,
			CLASSROOM_OPEN, CLASSROOM_CLOSE, Equipment.PROJECTOR);
	private Classroom classroomB1 = new Classroom(B1_NAME, B1_CAPACITY,
			CLASSROOM_OPEN, CLASSROOM_CLOSE, Equipment.WHITEBOARD);
	private Classroom classroomC1 = new Classroom(C1_NAME, C1_CAPACITY,
			CLASSROOM_OPEN, CLASSROOM_CLOSE, Equipment.WHITEBOARD + Equipment.PROJECTOR);

	@Test
	public void shouldPopulateName() {
		assertEquals(A1_NAME, classroomA1.getName());
		assertEquals(B1_NAME, classroomB1.getName());
	}

	@Test
	public void shouldSetCapacity() {
		assertEquals(A1_CAPACITY, classroomA1.getCapacity());
		assertEquals(B1_CAPACITY, classroomB1.getCapacity());
	}

	@Test
	public void shouldBeAvailableByDefault() {
		int hour = 11;
		assertTrue(hour >= CLASSROOM_OPEN && hour <= CLASSROOM_CLOSE);
		
		assertTrue(classroomA1.isAvailableAt(hour));
	}
	
	@Test
	public void canNotBookSameHourMoreThanOnce() {
		int hour = 11;
		assertTrue(hour >= CLASSROOM_OPEN && hour <= CLASSROOM_CLOSE);
		
		assertTrue(classroomA1.book(hour));
		assertFalse(classroomA1.book(hour));
	}

	@Test
	public void bookingShouldMakeClassroomUnavailable() {
		classroomA1.book(11);
		assertFalse(classroomA1.isAvailableAt(11));
	}

	@Test
	public void canNotBookClassroomTooEarly() {
		int hour = 8;
		assertTrue(hour < CLASSROOM_OPEN);

		assertFalse(classroomA1.book(hour));
	}
	
	@Test
	public void canNotBookClassroomTooLate() {
		int hour = 18;
		assertTrue(hour > CLASSROOM_CLOSE);

		assertFalse(classroomA1.book(hour));
	}
	
	@Test
	public void setOpen() {
		assertEquals(CLASSROOM_OPEN, classroomA1.getOpen());
		assertEquals(CLASSROOM_OPEN, classroomB1.getOpen());
	}
	
	@Test
	public void setClose() {
		assertEquals(CLASSROOM_CLOSE, classroomA1.getClose());
		assertEquals(CLASSROOM_CLOSE, classroomB1.getClose());
	}
	
	@Test
	public void hasSinglePieceOfEquipment() {
		assertTrue(classroomA1.hasEquipment(Equipment.PROJECTOR));
		assertTrue(classroomB1.hasEquipment(Equipment.WHITEBOARD));
		assertFalse(classroomA1.hasEquipment(Equipment.WHITEBOARD));
	}
	
	@Test
	public void hasMultiplePiecesOfEquipment() {
		assertTrue(classroomC1.hasEquipment(Equipment.PROJECTOR));
		assertTrue(classroomC1.hasEquipment(Equipment.WHITEBOARD));
		assertTrue(classroomC1.hasEquipment(Equipment.PROJECTOR + Equipment.WHITEBOARD));
		assertFalse(classroomC1.hasEquipment(Equipment.MICROPHONE));
	}
}
