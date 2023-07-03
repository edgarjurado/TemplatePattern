package com.perficient.samples.patterns.init;

import java.util.ArrayList;
import java.util.List;

import com.perficient.samples.patterns.template.schema.exceptions.InvalidFileTypeException;
import com.perficient.samples.patterns.template.schema.fileloaders.CSVFileComparator;
import com.perficient.samples.patterns.template.schema.fileloaders.FileComparator;

public class TemplateTest {

	public static void main(String[] args) {
		FileComparator comparer=new CSVFileComparator();
		List<Integer> invoices=new ArrayList<>();
		invoices.add(354);
		try {
			comparer.compareProcess("C:\file.csv", "CsvSchema", invoices);
		} catch (InvalidFileTypeException e) {
			e.printStackTrace();
		}

	}
	
	
}
