package com.perficient.samples.patterns.template.schema.services;

import java.util.List;
import java.util.Map;

import com.perficient.samples.patterns.template.schema.ColumnsSchema;

public class DataLoaderService implements IDataLoaderService{

	@Override
	public void loadData(List<Map<String, String>> transformedValues) {
		System.out.println("Insert values from file to DB");
	}

	@Override
	public ColumnsSchema getColumnsSchema(String schema) {
		System.out.println("Fetch from Database the schema called");
		return new ColumnsSchema();		
	}

	@Override
	public void insertComparison(List<Map<String, String>> results) {
		System.out.println("Insert comparison results to DB");
	}

	

}
