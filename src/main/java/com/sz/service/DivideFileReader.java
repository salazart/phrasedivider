package com.sz.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class DivideFileReader {
	private String fileName;
	private CounterHashMap counterHashMap;
	
	public DivideFileReader(String fileName) {
		this.fileName = fileName;
		this.counterHashMap = new CounterHashMap();
	}
	
	public CounterHashMap readFile(String divider) throws IOException{
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] arrayOfValues = line.split(Pattern.quote(divider));
		    	List<String> values = Arrays.asList(arrayOfValues);
		    	values.forEach(value -> counterHashMap.addElement(value));
		    }
		} catch (IOException e) {
			throw e;
		}
		return counterHashMap;
	}
}
