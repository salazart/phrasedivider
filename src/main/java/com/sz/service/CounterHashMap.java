package com.sz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CounterHashMap extends HashMap<String, Integer>{
	
	private Map<String, Integer> map = new HashMap();
	
	public void addElement(String key){
		Integer counter = map.get(key);
		if(counter != null){
			counter++;
			map.put(key, counter);
		} else {
			map.put(key, 1);
		}
	}
	
	public List<String> getMaxCounter(int countMaxValues){
		List<Integer> counters = map.values().stream()
			.sorted((e1, e2) -> Integer.compare(e2, e1))
			.limit(countMaxValues)
			.collect(Collectors.toList());
		
		List<String> values = getValuesByCounters(counters);
		
		return values;
	
	}

	private List<String> getValuesByCounters(List<Integer> counters) {
		List<String> values = new ArrayList<>();
		for (Integer counter : counters) {
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
		        if (Objects.equals(counter, entry.getValue())) {
		            values.add(entry.getKey());
		        }
		    }
		}
		return values;
	}

}
