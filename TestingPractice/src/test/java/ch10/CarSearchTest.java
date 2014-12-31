package test.java.ch10;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import main.java.ch10.Car;
import main.java.ch10.CarSearch;
import main.java.ch10.Engine;
import main.java.ch10.Manufacturer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CarSearchTest {

	private final String SPORT_CAR_NAME = "Ferrari";
	
	Car sportCar = Mockito.mock(Car.class);
	Engine sportEngine = Mockito.mock(Engine.class);
	Manufacturer sportManufacturer = Mockito.mock(Manufacturer.class);
	Car normalCar = Mockito.mock(Car.class);
	Engine normalEngine = Mockito.mock(Engine.class);
	Manufacturer normalManufacturer = Mockito.mock(Manufacturer.class);
	
	CarSearch search = new CarSearch();
	
	@Before
	public void setup() {
		// sport car
		when(sportCar.getColor()).thenReturn(Color.RED);
		when(sportEngine.getNbOfCylinders()).thenReturn(7);
		when(sportCar.getEngine()).thenReturn(sportEngine);
		when(sportManufacturer.getName()).thenReturn(SPORT_CAR_NAME);
		when(sportCar.getManufacturer()).thenReturn(sportManufacturer);
		
		// normal car
		when(normalCar.getColor()).thenReturn(Color.BLUE);
		when(normalEngine.getNbOfCylinders()).thenReturn(6);
		when(normalCar.getEngine()).thenReturn(normalEngine);
		when(normalManufacturer.getName()).thenReturn(SPORT_CAR_NAME);
		when(normalCar.getManufacturer()).thenReturn(normalManufacturer);
		
		search.addCar(normalCar);
		search.addCar(sportCar);
	}
	
	@Test
	public void shouldNotConsiderLowCylinderCarsSportsCar() {
		assertThat(search.findSportsCars()).hasSize(1);
		
		when(sportEngine.getNbOfCylinders()).thenReturn(6);
		assertThat(search.findSportsCars()).hasSize(0);
		
		when(sportEngine.getNbOfCylinders()).thenReturn(8);
		assertThat(search.findSportsCars()).hasSize(1);
	}
	
	public void onlyRedCarsAreConsideredSportCars() {
		// ..
	}
	
	// stupid amount more tests
}
