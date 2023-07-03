package com.perficient.samples.patterns.template.schema.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Records {

	
	public static List<Map<String, String>> getData() {
		
		List<Map<String, String>> data=new ArrayList<>();
		Map<String, String> record=new HashMap<>();
		record.put("id", "1");
		record.put("name","Peter Parker");
		record.put("Salary", "1000");
		record.put("amount", "150");
		record.put("period","1Y");
		record.put("Start date", "01/01/2023");
		record.put("reinvest", "true");
		data.add(record);
		
		record=new HashMap<>();
		record.put("id", "2");
		record.put("name","Steve Rogers");
		record.put("Salary", "10000");
		record.put("amount", "250");
		record.put("period","1Y");
		record.put("Start date", "01/01/2023");
		record.put("reinvest", "true");
		data.add(record);
		
		record=new HashMap<>();
		record.put("id", "3");
		record.put("name","Tony Stark");
		record.put("Salary", "100000000");
		record.put("amount", "125000000");
		record.put("period","5Y");
		record.put("Start date", "01/01/2023");
		record.put("reinvest", "true");
		data.add(record);
		return data;
	}

	
}
