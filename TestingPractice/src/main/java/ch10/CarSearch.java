package main.java.ch10;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class CarSearch {

	private List<Car> cars = new ArrayList<Car>();
	
	public void addCar(Car car) {
		cars.add(car);
	}
	
	public List<Car> findSportsCars() {
		List<Car> sportsCars = new ArrayList<Car>();
		
		for (Car car : cars) {
			if (car.getEngine().getNbOfCylinders() > 6
					&& Color.RED == car.getColor()
					&& "Ferrari".equals(car.getManufacturer().getName())) {
				
				sportsCars.add(car);
			}
		}
		
		return sportsCars;
	}
}
