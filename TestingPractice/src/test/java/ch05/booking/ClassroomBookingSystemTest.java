package test.java.ch05.booking;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import main.java.ch05.booking.Classroom;
import main.java.ch05.booking.ClassroomBookingSystem;
import main.java.ch05.booking.data.ClassroomDataSource;

import org.junit.Before;
import org.junit.Test;

public class ClassroomBookingSystemTest {

	private ClassroomBookingSystem mBookingSystem;
	private Classroom A1 = mock(Classroom.class);
	private final String A1_NAME = "A1";
	private Classroom B1 = mock(Classroom.class);
	private final String B1_NAME = "B1";

	@Before
	public void setup() {
		List<Classroom> data = new ArrayList<Classroom>();
		data.add(A1);
		data.add(B1);

		ClassroomDataSource ds = mock(ClassroomDataSource.class);
		when(ds.allClassrooms()).thenReturn(data);

		mBookingSystem = new ClassroomBookingSystem(data);

		when(A1.getName()).thenReturn(A1_NAME);
		when(A1.isAvailableAt(11)).thenReturn(true);
		when(A1.getCapacity()).thenReturn(20);
		when(A1.getOpen()).thenReturn(9);
		when(A1.getClose()).thenReturn(17);
		when(A1.hasEquipment(Equipment.PROJECTOR + Equipment.WHITEBOARD))
				.thenReturn(true);

		when(B1.getName()).thenReturn(B1_NAME);
		when(B1.isAvailableAt(11)).thenReturn(false);
		when(B1.getCapacity()).thenReturn(30);
		when(B1.getOpen()).thenReturn(9);
		when(B1.getClose()).thenReturn(17);
	}

	@Test
	public void shouldListAllClassrooms() {
		assertTrue(mBookingSystem.listAllClassrooms().size() > 0);
	}

	@Test
	public void shouldListClassroomsForTimeslot() {
		for (Classroom classroom : mBookingSystem.listAvailableClassrooms(11)) {
			assertTrue(classroom.isAvailableAt(11));
		}
	}

	@Test
	public void shouldListClassroomsForName() {
		for (Classroom classroom : mBookingSystem.listClassrooms(A1_NAME)) {
			assertEquals(A1_NAME, classroom.getName());
		}
		for (Classroom classroom : mBookingSystem.listClassrooms(B1_NAME)) {
			assertEquals(B1_NAME, classroom.getName());
		}
	}

	@Test
	public void requiredEquipmentShouldBeFiltered() {
		assertTrue(A1.hasEquipment(Equipment.PROJECTOR + Equipment.WHITEBOARD));

		List<Classroom> rooms = mBookingSystem
				.listClassroomWith(Equipment.PROJECTOR + Equipment.WHITEBOARD);
		
		assertArrayEquals(new Classroom[] { A1 }, rooms.toArray());
	}

}
