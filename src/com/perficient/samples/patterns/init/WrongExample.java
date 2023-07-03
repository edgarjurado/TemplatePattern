package com.perficient.samples.patterns.init;

import java.util.ArrayList;
import java.util.List;

import com.perficient.samples.patterns.template.schema.exceptions.InvalidFileTypeException;
import com.perficient.samples.patterns.template.schema.fileloaders.WrongFileComparator;

public class WrongExample {

	public static void main(String[] args) {
		WrongFileComparator fc=new WrongFileComparator();
		List<Integer> invoices=new ArrayList<>();
		invoices.add(354);
		try {
			fc.compareProcess("C:\file.csv", "CsvSchema", invoices);
		} catch (InvalidFileTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
