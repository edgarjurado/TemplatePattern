package com.perficient.samples.patterns.template.schema.fileloaders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.perficient.samples.patterns.template.schema.ColumnsSchema;
import com.perficient.samples.patterns.template.schema.exceptions.InvalidFileTypeException;
import com.perficient.samples.patterns.template.schema.services.DataLoaderService;
import com.perficient.samples.patterns.template.schema.services.IDataLoaderService;
import com.perficient.samples.patterns.template.schema.services.IInvoiceService;
import com.perficient.samples.patterns.template.schema.services.InvoiceService;
import com.perficient.samples.patterns.template.schema.utils.ITransformUtils;
import com.perficient.samples.patterns.template.schema.utils.Records;
import com.perficient.samples.patterns.template.schema.utils.TransformUtils;

public class WrongFileComparator {

	IDataLoaderService dataLoaderService=new DataLoaderService();
	IInvoiceService invoiceService=new InvoiceService();
	
	public void compareProcess(String path, String schema, List<Integer> invoiceIds) throws InvalidFileTypeException { 
		
		int index=path.lastIndexOf('.');		
		String extension=path.substring(index+1);
		ITransformUtils transformUtils=new TransformUtils();
		
		List<Map<String, String>> invoiceRecords;
		List<Map<String, String>> results;
		
		switch(extension) {
			case "csv":
				System.out.println("If path file has extension csv and file can be read as csv, we continue");
				
				//reads file
				File csvFile=new File(path);
				
				//load schema for file
				ColumnsSchema csvSchema=dataLoaderService.getColumnsSchema(schema);
				
				//parses file with the schema selected and loads info into a list
				System.out.println("reads csv file and match the values with the columns template");
				List<Map<String, String>> info=Records.getData();
				
				//gets info and makes calculations from raw file
				System.out.println("Iterate through the data...");
				System.out.println("Applying validations and adjustments:");
				List<Map<String, String>> transformedValues=new ArrayList<>();
				
				for (Map<String, String> map : info) {
					map.put("ValidatedAmount",transformUtils.validateValues(map).toString());
					map.put("ScaledAmount",transformUtils.scaleValues(map).toString());
					transformedValues.add(map);
				}
				
				System.out.println("Merging duplicated records");
				invoiceRecords=invoiceService.getInvoiceRecords(invoiceIds);
				dataLoaderService.loadData(transformedValues);
				System.out.println("Comparing invoice records in file and invoice");
				results= transformedValues;
				dataLoaderService.insertComparison(results);
				break;
			case "xls":
				System.out.println("If path file has extension xls and file can be read as xls, we continue");
				
				//reads file
				File xlsFile=new File(path);
				
				//load schema for file
				ColumnsSchema xlsSchema=dataLoaderService.getColumnsSchema(schema);
				
				//parses file with the schema selected and loads info into a list
				System.out.println("reads xls file and match the values with the columns template");
				List<Map<String, String>> xlsInfo=Records.getData();
				
				//gets info and makes calculations from raw file
				System.out.println("Iterate through the data...");
				System.out.println("Applying validations and adjustments:");
				List<Map<String, String>> xlsTransformedValues=new ArrayList<>();
				
				for (Map<String, String> map : xlsInfo) {
					map.put("ValidatedAmount",transformUtils.validateValues(map).toString());
					map.put("ScaledAmount",transformUtils.scaleValues(map).toString());
					xlsTransformedValues.add(map);
				}
				
				System.out.println("Merging duplicated records");
				
				invoiceRecords=invoiceService.getInvoiceRecords(invoiceIds);
				dataLoaderService.loadData(xlsTransformedValues);
				System.out.println("Comparing invoice records in file and invoice");
				results= xlsTransformedValues;
				dataLoaderService.insertComparison(results);
				break;
		}

	}
}
