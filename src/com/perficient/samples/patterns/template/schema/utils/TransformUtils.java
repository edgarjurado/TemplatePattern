package com.perficient.samples.patterns.template.schema.utils;

import java.util.Map;

public class TransformUtils implements ITransformUtils{

	

	@Override
	public Double scaleValues(Map<String, String> map) {
		System.out.println("Applying scaling to customer " + map.get("id"));
		Double scaled= (Double.parseDouble(map.get("amount"))*0.12)*30/365;
		System.out.println("------------->Scaled value: " + scaled);
		return scaled;
	}

	@Override
	public Double validateValues(Map<String, String> map) {
		System.out.println("Validating customer " + map.get("id"));
		double d= Double.parseDouble(map.get("amount"));
		Double valid=d>0?d:0.0;
		System.out.println("------------->Validated amount: " + valid);
		return valid;
	}
}
