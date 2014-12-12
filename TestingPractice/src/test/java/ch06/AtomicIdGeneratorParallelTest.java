package test.java.ch06;

import java.util.HashSet;
import java.util.Set;

import main.java.ch06.AtomicIdGenerator;
import main.java.ch06.IdGenerator;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;

public class AtomicIdGeneratorParallelTest {

	@Rule
	public ConcurrentRule concurrently = new ConcurrentRule();
	
	@Rule
	public RepeatingRule repeatedly = new RepeatingRule();
	
	private IdGenerator idGen = new AtomicIdGenerator();
	private Set<Long> ids = new HashSet<Long>();
	
	@Test
	@Concurrent(count = 10)
	@Repeating(repetition = 1000)
	public void idsShouldBeUnique() {
		assertTrue(ids.add(idGen.nextId()));
	}
	
}
