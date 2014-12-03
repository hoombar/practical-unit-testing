package test.java;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class HashMapTest {

	private final String KEY1 = "key";
	private final String KEY2 = "key2";
	private final String VALUE1 = "value1";
	private final String VALUE2 = "value2";
	
	private HashMap<String, String> mHashMap;
	
	@Before
	public void setup() {
		mHashMap = new HashMap<>();
	}
	
	@Test
	public void getShouldRetrievePutValue() {
		mHashMap.put(KEY1, VALUE1);

		assertEquals(VALUE1, mHashMap.get(KEY1));
	}
	
	@Test
	public void putSameKeyShouldReplace() {
		mHashMap.put(KEY1, VALUE1);
		mHashMap.put(KEY1, VALUE2);
		
		assertEquals(VALUE2, mHashMap.get(KEY1));
	}
	
	@Test
	public void clearRemovesAllElements() {
		mHashMap.put(KEY1, VALUE1);
		mHashMap.put(KEY2, VALUE2);
		
		assertEquals(2, mHashMap.size());
		
		mHashMap.clear();
		
		assertEquals(0, mHashMap.size());
	}
	
	@Test
	public void nullCanBeUsedAsKey() {
		mHashMap.put(null, VALUE1);
		
		assertEquals(1, mHashMap.size());
		assertEquals(VALUE1, mHashMap.get(null));
	}
	
	
}
