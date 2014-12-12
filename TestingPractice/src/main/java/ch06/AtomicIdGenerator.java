package main.java.ch06;

public class AtomicIdGenerator implements IdGenerator {

	private static Long nextId = System.currentTimeMillis();
	
	@Override
	public synchronized Long nextId() {
		return nextId++;
	}

}
