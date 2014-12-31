package main.java.ch10;

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
			if (car.isSportsCar()) {
				sportsCars.add(car);
			}
		}
		
		return sportsCars;
	}
}
