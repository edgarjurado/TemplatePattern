package com.perficient.samples.patterns.template.schema.services;

import java.util.List;
import java.util.Map;

import com.perficient.samples.patterns.template.schema.ColumnsSchema;

public interface IDataLoaderService {

	void loadData(List<Map<String, String>> transformedValues);

	ColumnsSchema getColumnsSchema(String columnsTemplate);

	void insertComparison(List<Map<String, String>> results);

}
