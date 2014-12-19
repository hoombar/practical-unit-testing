package main.java.ch09;

public class TransactionBuilder {

	public enum State {
		PROCESSING,
		OK,
		CANCELLED,
		ERROR
	}
	
	// defaults
	private long id = -1;
	private State state = State.PROCESSING;
	private boolean retryAllowed = false;
	private String message;
	private String billingId;
	
	private TransactionBuilder(long id) {
		this.id = id;
	}
	
	public static TransactionBuilder create(long id) {
		return new TransactionBuilder(id);
	}
	
	public TransactionBuilder retry(boolean retryAllowed) {
		this.retryAllowed = retryAllowed;
		
		return this;
	}
	
	public TransactionBuilder message(String message) {
		this.message = message;
		
		return this;
	}
	
	public TransactionBuilder state(State state) {
		this.state = state;
		
		return this;
	}
	
	public TransactionBuilder billingId(String billingId) {
		this.billingId = billingId;
		
		return this;
	}
	
	public Transaction build() {
		Transaction transaction = new Transaction();
		transaction.setId(id);
		transaction.setState(state.toString());
		transaction.setRetryAllowed(retryAllowed);
		transaction.setMessage(message);
		transaction.setBillingId(billingId);
		
		return transaction;
	}
	
}
