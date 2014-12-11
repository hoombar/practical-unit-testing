package test.java.ch06;

import static junitparams.JUnitParamsRunner.$;
import static org.mockito.Mockito.*;
import static org.fest.assertions.api.Assertions.*;

import java.util.Calendar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import main.java.ch06.HelpDesk;
import main.java.ch06.TimeProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.googlecode.catchexception.CatchException;

@RunWith(JUnitParamsRunner.class)
public class HelpDeskTest {

	TimeProvider timeProvider = mock(TimeProvider.class);
	HelpDesk helpdesk = new HelpDesk(timeProvider);
	Calendar monday = Calendar.getInstance();
	Calendar friday = Calendar.getInstance();
	Calendar saturday = Calendar.getInstance();
	Calendar sunday = Calendar.getInstance();
	
	@SuppressWarnings("unused")
	private static final Object[] validHours() {
		return $(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23);
	}
	
	private static final Object[] invalidHours() {
		return $(-1,24,100,-50);
	}
	
	@Before
	public void setup() {
		monday.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		friday.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		saturday.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		sunday.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
	}

	@Test
	@Parameters(method = "validHours")
	public void shouldAcceptAnyHourOnMonday(int hour) {
		monday.set(Calendar.HOUR_OF_DAY, hour);
		when(timeProvider.getTime()).thenReturn(monday);
		
		assertThat(helpdesk.willHandleIssue(null)).isEqualTo(true);
	}

	@Test
	@Parameters(method = "validHours")
	public void shouldNotAcceptOutOfBusinessHoursOnFriday(int hour) {
		friday.set(Calendar.HOUR_OF_DAY, hour);
		when(timeProvider.getTime()).thenReturn(friday);
		
		boolean expected = true;
		if (hour > HelpDesk.EOB_HOUR) {
			expected = false;
		}
		
		assertThat(helpdesk.willHandleIssue(null)).isEqualTo(expected);
	}
	
	@Test
	@Parameters(method = "validHours")
	public void shouldNotAcceptAtWeekend(int hour) {
		saturday.set(Calendar.HOUR_OF_DAY, hour);
		sunday.set(Calendar.HOUR_OF_DAY, hour);
		
		when(timeProvider.getTime()).thenReturn(saturday);
		assertThat(helpdesk.willHandleIssue(null)).isEqualTo(false);
		when(timeProvider.getTime()).thenReturn(sunday);
		assertThat(helpdesk.willHandleIssue(null)).isEqualTo(false);
	}
	
	@Test
	@Parameters(method = "invalidHours")
	public void shouldNotAcceptInvlalidHours(int hour) {
		monday.set(Calendar.HOUR_OF_DAY, hour);
		when(timeProvider.getTime()).thenReturn(monday);

		helpdesk.willHandleIssue(null);
	}

}
