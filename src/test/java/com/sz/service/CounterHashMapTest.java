package com.sz.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CounterHashMapTest {
	private static final int COUNT_FIRST_VALUES = 2;
	private String PHRASE_1 = "hello";
	private String PHRASE_2 = "How are you?";
	private String PHRASE_3 = "I am fine.";
	
	private CounterHashMap counterHashMap = new CounterHashMap();
	
	@Before
	public void before(){
		counterHashMap.addElement(PHRASE_1);
		counterHashMap.addElement(PHRASE_1);
		counterHashMap.addElement(PHRASE_2);
		counterHashMap.addElement(PHRASE_2);
		counterHashMap.addElement(PHRASE_2);
		counterHashMap.addElement(PHRASE_3);
	}
	
	@Test
	public void test() {
		List<String> values = counterHashMap.getMaxCounter(COUNT_FIRST_VALUES);
		System.out.println(values);
		assertTrue(values.size() == 2);
	}

}
