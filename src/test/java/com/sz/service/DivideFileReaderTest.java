package com.sz.service;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DivideFileReaderTest {
	private List<String> phrases = Arrays.asList("hello", "How are you?", "I am fine.");
	
	private static final int COUNT_FIRST_VALUES = 5;
	private static final String fileName = "test.txt";
	private static final String divider = "|";
	private DivideFileReader divideFileReader;
	private Random random = new Random();
	
	@Before
	public void before(){
		divideFileReader = new DivideFileReader(fileName);
		
		StringJoiner joiner = new StringJoiner(divider);
		int count = random.nextInt(1000000);
		for (int i = 0; i < count; i++) {
			joiner.add(getPhrase());
		}
		
		try {
			if (!Files.exists(Paths.get(fileName))) {
			    Files.createFile(Paths.get(fileName));
			}
			Files.write(Paths.get(fileName), joiner.toString().getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getPhrase() {
		return phrases.get(random.nextInt(3));
	}
	
	@After
	public void after(){
		try {
			Files.delete(Paths.get(fileName));
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	@Test
	public void test() {
		CounterHashMap counterHashMap = null;
		try {
			counterHashMap = divideFileReader.readFile(divider);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		List<String> values = counterHashMap.getMaxCounter(COUNT_FIRST_VALUES);
		System.out.println(values);
		fail("Not yet implemented");
	}

}
