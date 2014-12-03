package main.java.ch05.booking.data;

import java.util.ArrayList;
import java.util.List;

import test.java.ch05.booking.Equipment;

import main.java.ch05.booking.Classroom;

public class ClassroomDataSource {

	public List<Classroom> allClassrooms() {
		List<Classroom> result = new ArrayList<Classroom>();
		
		result.add(new Classroom("A1", 20, 9, 17, Equipment.PROJECTOR));
		result.add(new Classroom("B1", 30, 8, 16, Equipment.WHITEBOARD));
		result.add(new Classroom("C2", 40, 10, 18, Equipment.PROJECTOR + Equipment.WHITEBOARD));
		
		return result;
	}
	
}
