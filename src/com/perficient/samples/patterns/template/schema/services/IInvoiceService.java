package com.perficient.samples.patterns.template.schema.services;

import java.util.List;
import java.util.Map;

public interface IInvoiceService {

	List<Map<String, String>> getInvoiceRecords(List<Integer> invoiceIds);

}
