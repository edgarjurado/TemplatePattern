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
import com.perficient.samples.patterns.template.schema.utils.TransformUtils;

public abstract class FileComparator {

	IDataLoaderService dataLoaderService=new DataLoaderService();
	ITransformUtils transformUtils=new TransformUtils();
	private IInvoiceService invoiceService=new InvoiceService();
	
	protected abstract List<Map<String, String>> parseFile(File f, ColumnsSchema ct);
	protected abstract boolean validateFileType(String path);
	
	public void compareProcess(String path, String schema, List<Integer> invoiceIds) throws InvalidFileTypeException {
		//Read file form location given
		File f=readFile(path);
		ColumnsSchema columnsSchema=getColumnsSchema(schema);
		List<Map<String, String>> invoiceRecords=invoiceService.getInvoiceRecords(invoiceIds);
		List<Map<String, String>> info=parseFile(f,columnsSchema);
		List<Map<String, String>> transformedValues=processRawValues(info);
		dataLoaderService.loadData(transformedValues);
		List<Map<String, String>> results= compare(transformedValues, invoiceRecords);
		dataLoaderService.insertComparison(results);
		
	}

	
	private List<Map<String, String>> compare(List<Map<String, String>> fileValues,
			List<Map<String, String>> invoices) {
		System.out.println("Comparing invoice records in file and invoice");
		return fileValues;
	}
	
	protected List<Map<String, String>> processRawValues(List<Map<String, String>> info) {
		System.out.println("Iterate through the data...");
		System.out.println("Applying validations and adjustments:");
		List<Map<String, String>> result=new ArrayList<>();
		for (Map<String, String> map : info) {
			map.put("ValidatedAmount",transformUtils.validateValues(map).toString());
			map.put("ScaledAmount",transformUtils.scaleValues(map).toString());
			result.add(map);
		}
		
		
		System.out.println("Merging duplicated records");
		return result;
	}	

	protected ColumnsSchema getColumnsSchema(String schema) {
		return dataLoaderService.getColumnsSchema(schema);
	}

	protected File readFile(String path) throws InvalidFileTypeException {
		if (validateFileType(path)) {
			return new File(path);
		}else {
			throw new InvalidFileTypeException();
		}
		
	}
	
	public IInvoiceService getInvoiceService() {
		return invoiceService;
	}
	public void setInvoiceService(IInvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
}
