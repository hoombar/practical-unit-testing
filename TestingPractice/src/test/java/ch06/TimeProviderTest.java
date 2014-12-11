package test.java.ch06;

import static junitparams.JUnitParamsRunner.$;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import main.java.ch06.TimeProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class TimeProviderTest {

	Calendar calendar = Calendar.getInstance();
	TimeProvider timeProvider = new TimeProvider();
	
	@SuppressWarnings("unused")
	private static final Object[] getMorningHours() {
		return $(0,1,2,3,4,5,6,7,8,9,10,11);
	}
	
	@SuppressWarnings("unused")
	private static final Object[] getAfternoonHours() {
		return $(12,13,14,15,16,17);
	}
	
	@SuppressWarnings("unused")
	private static final Object[] getEveningHours() {
		return $(18,19,20,21,22,23);
	}
	
	@Before
	public void setup() {
		timeProvider.load(calendar);
	}
	
	@Test
	@Parameters(method = "getMorningHours")
	public void shouldOnlyEvalMorningWhenMorningHours(int hour) {
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		
		assertThat(timeProvider.isMorning()).isEqualTo(true);
		assertThat(timeProvider.isAfternoon()).isEqualTo(false);
		assertThat(timeProvider.isEvening()).isEqualTo(false);
	}
	
	@Test
	@Parameters(method = "getAfternoonHours")
	public void shouldOnlyEvalAfternoonWhenAfternoonHours(int hour) {
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		
		assertThat(timeProvider.isMorning()).isEqualTo(false);
		assertThat(timeProvider.isAfternoon()).isEqualTo(true);
		assertThat(timeProvider.isEvening()).isEqualTo(false);
	}
	
	@Test
	@Parameters(method = "getEveningHours")
	public void shouldOnlyEvalEveningWhenEveningHours(int hour) {
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		
		assertThat(timeProvider.isMorning()).isEqualTo(false);
		assertThat(timeProvider.isAfternoon()).isEqualTo(false);
		assertThat(timeProvider.isEvening()).isEqualTo(true);
	}
	
}
