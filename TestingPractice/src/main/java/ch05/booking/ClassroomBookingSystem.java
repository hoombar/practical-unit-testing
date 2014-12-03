package main.java.ch05.booking;

import java.util.ArrayList;
import java.util.List;

public class ClassroomBookingSystem {

	private List<Classroom> classrooms;
	
	public ClassroomBookingSystem(List<Classroom> data) {
		this.classrooms = data;
	}
	
	public List<Classroom> listAllClassrooms() {
		return classrooms;
	}

	public List<Classroom> listClassrooms(String name) {
		List<Classroom> result = new ArrayList<Classroom>();
		
		for (Classroom classroom : classrooms) {
			if (classroom.getName().equals(name)) {
				result.add(classroom);
			}
		}
		
		return result;
	}

	public List<Classroom> listAvailableClassrooms(int hour) {
		List<Classroom> result = new ArrayList<Classroom>();
		
		for (Classroom classroom : classrooms) {
			if (classroom.isAvailableAt(hour)) {
				result.add(classroom);	
			}
		}
		
		return result;
	}

	public List<Classroom> listClassroomWith(int i) {
		List<Classroom> found = new ArrayList<Classroom>();
		
		for (Classroom room : classrooms) {
			if (room.hasEquipment(i)) {
				found.add(room);
			}
		}
		
		return found;
	}

}
