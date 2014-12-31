package test.java.ch10;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import main.java.ch10.Car;
import main.java.ch10.CarSearch;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CarSearchTest {

	Car sportCar = Mockito.mock(Car.class);
	Car normalCar = Mockito.mock(Car.class);
	
	CarSearch search = new CarSearch();
	
	@Before
	public void setup() {
		// sport car
		when(sportCar.isSportsCar()).thenReturn(true);
		
		// normal car
		when(normalCar.isSportsCar()).thenReturn(false);
		
		search.addCar(normalCar);
		search.addCar(sportCar);
	}
	
	@Test
	public void shouldOnlyFindSportsCars() {
		assertThat(search.findSportsCars()).hasSize(1);
		
		when(normalCar.isSportsCar()).thenReturn(true);
		assertThat(search.findSportsCars()).hasSize(2);
		
		when(sportCar.isSportsCar()).thenReturn(false);
		when(normalCar.isSportsCar()).thenReturn(false);
		assertThat(search.findSportsCars()).hasSize(0);
	}
}
