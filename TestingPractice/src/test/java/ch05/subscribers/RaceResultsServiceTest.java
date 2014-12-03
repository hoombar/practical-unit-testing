package test.java.ch05.subscribers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import main.java.ch05.subscribers.Client;
import main.java.ch05.subscribers.Logger;
import main.java.ch05.subscribers.Message;
import main.java.ch05.subscribers.RaceResultsService;
import main.java.ch05.subscribers.SubscriptionType;
import main.java.ch05.subscribers.RaceResultsService.NotSubscribedException;

import org.junit.Test;

public class RaceResultsServiceTest {

	private Logger logger = mock(Logger.class);
	private RaceResultsService raceResults = new RaceResultsService(logger);
	private Message message = mock(Message.class);
	private Client clientA = mock(Client.class, "ClientA");
	private Client clientB = mock(Client.class, "ClientB");
	private SubscriptionType defaultType = SubscriptionType.horse;
	
	@Test
	public void notSubscribedClientsShouldNotReceiveMessage() {
		raceResults.send(message, defaultType);
		
		verify(clientA, never()).receive(message);
		verify(clientB, never()).receive(message);
	}
	
	@Test
	public void subscribedClientShouldReceiveMessages() {
		raceResults.addSubscriber(clientA, defaultType);
		raceResults.send(message, defaultType);
		
		verify(clientA).receive(message);
	}
	
	@Test
	public void allSubscribedClientsShouldReceiveMessages() {
		raceResults.addSubscriber(clientA, defaultType);
		raceResults.addSubscriber(clientB, defaultType);
		raceResults.send(message, defaultType);
		
		verify(clientA).receive(message);
		verify(clientB).receive(message);
	}
	
	@Test
	public void shouldSendOnlyOneMessageToMultiSubscriber() {
		raceResults.addSubscriber(clientA, defaultType);
		raceResults.addSubscriber(clientA, defaultType);
		raceResults.send(message, defaultType);
		
		verify(clientA).receive(message);
	}
	
	@Test
	public void unsubscribedClientShouldNotReceiveMessages() {
		raceResults.addSubscriber(clientA, defaultType);
		raceResults.removeSubscriber(clientA);
		raceResults.send(message, defaultType);
		
		verify(clientA, never()).receive(message);
	}
	
	@Test
	public void shouldSendOnlyToClientOfSameType() {
		Client boatSubscriber = clientA;
		Client horseSubscriber = clientB;
		
		raceResults.addSubscriber(horseSubscriber, SubscriptionType.horse);
		raceResults.addSubscriber(boatSubscriber, SubscriptionType.boat);
		raceResults.send(message, SubscriptionType.horse);
		
		verify(boatSubscriber, never()).receive(message);
		verify(horseSubscriber).receive(message);
	}
	
	@Test
	public void allMessagesShouldBeLogged() {
		raceResults.send(message, defaultType);
		
		verify(logger).log(message);
	}
	
	@Test
	public void subscribersReceiveMultipleMessages() {
		raceResults.addSubscriber(clientA, defaultType);
		
		Message message2 = mock(Message.class);
		Message message3 = mock(Message.class);
		
		raceResults.send(message, defaultType);
		verify(clientA).receive(message);
		raceResults.send(message2, defaultType);
		verify(clientA).receive(message2);
		raceResults.send(message3, defaultType);
		verify(clientA).receive(message3);
	}
	
	@Test(expected = NotSubscribedException.class)
	public void clientThatIsNotSubscribedCanNotUnsubscribe() {
		raceResults.removeSubscriber(clientA);
	}
}
