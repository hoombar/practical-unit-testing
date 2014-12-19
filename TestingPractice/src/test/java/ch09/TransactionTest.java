package test.java.ch09;

import static org.fest.assertions.api.Assertions.assertThat;
import main.java.ch09.Transaction;
import main.java.ch09.TransactionBuilder;
import main.java.ch09.TransactionBuilder.State;

import org.junit.Test;

public class TransactionTest {

	private long transactionId = 123;
	private String billingId = "billing_id";
	private String message = "message";

	private TransactionBuilder builder = TransactionBuilder
			.create(transactionId);

	@Test
	public void shouldStoreRetryValue() {
		Transaction transactionWithNoRetry = builder.retry(false).build();
		assertThat(transactionWithNoRetry.isRetryAllowed()).isEqualTo(false);

		Transaction transactionWithRetry = builder.retry(true).build();
		assertThat(transactionWithRetry.isRetryAllowed()).isEqualTo(true);
	}

	@Test
	public void shouldStoreBillingId() {
		assertThat(builder.billingId(billingId).build().getBillingId())
				.isEqualTo(billingId);
	}

	@Test
	public void shouldStoreMessage() {
		assertThat(builder.message(message).build().getMessage()).isEqualTo(
				message);
	}

	@Test
	public void shouldStoreState() {
		assertThat(builder.state(State.CANCELLED).build().getState())
				.isEqualTo(State.CANCELLED.toString());

		assertThat(builder.state(State.ERROR).build().getState()).isEqualTo(
				State.ERROR.toString());

		assertThat(builder.state(State.OK).build().getState()).isEqualTo(
				State.OK.toString());

		assertThat(builder.state(State.PROCESSING).build().getState())
				.isEqualTo(State.PROCESSING.toString());
	}

	@Test
	public void defaultsAreUnchanged() {
		Transaction transaction = builder.build();

		assertThat(transaction.getId()).isEqualTo(transactionId);
		assertThat(transaction.getBillingId()).isNull();
		assertThat(transaction.getMessage()).isNull();
		assertThat(transaction.getState()).isEqualTo(
				State.PROCESSING.toString());
	}

}
