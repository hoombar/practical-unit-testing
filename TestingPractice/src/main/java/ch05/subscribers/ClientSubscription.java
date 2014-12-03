package main.java.ch05.subscribers;


public class ClientSubscription {

	private Client client;
	private SubscriptionType subscription;
	
	public ClientSubscription(Client c, SubscriptionType s) {
		client = c;
		subscription = s;
	}

	public SubscriptionType getSubscriptionType() {
		return subscription;
	}

	public Client getClient() {
		return client;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ClientSubscription)) return false;
		
		ClientSubscription other = (ClientSubscription) obj;
		if (other.getClient().hashCode() == client.hashCode()) {
			if (other.getSubscriptionType() == subscription) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return client.hashCode() + subscription.hashCode();
	}
}
