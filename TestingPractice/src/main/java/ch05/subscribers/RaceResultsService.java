package main.java.ch05.subscribers;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class RaceResultsService {

	private Collection<ClientSubscription> subscriptions = new HashSet<ClientSubscription>();
	private Logger logger;
	
	public RaceResultsService(Logger logger) {
		this.logger = logger;
	}
	
	public void addSubscriber(Client client, SubscriptionType type) {
		subscriptions.add(new ClientSubscription(client, type));
	}
	
	public void send(Message message, SubscriptionType type) {
		logger.log(message);
		
		for (ClientSubscription client : subscriptions) {
			if (client.getSubscriptionType() == type) {
				client.getClient().receive(message);	
			}
		}
	}

	public void removeSubscriber(Client client) {
		boolean unsubscribed = false;
		
		for (ClientSubscription cs : subscriptions) {
			if (cs.getClient() == client) {
				subscriptions.remove(cs);
				unsubscribed = true;
			}
		}
		
		if (!unsubscribed) {
			throw new NotSubscribedException();
		}
	}
	
	public class NotSubscribedException extends RuntimeException {
		
		/**
		 * Auto-generated
		 */
		private static final long serialVersionUID = 1394004290986457560L;
	}
}
