package com.perficient.samples.patterns.template.schema.fileloaders;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.perficient.samples.patterns.template.schema.ColumnsSchema;
import com.perficient.samples.patterns.template.schema.utils.Records;

public class CSVFileComparator extends FileComparator {

	@Override
	protected List<Map<String, String>> parseFile(File f, ColumnsSchema ct) {
		System.out.println("reads csv file and match the values with the columns template");
		return Records.getData();
	}

	@Override
	protected boolean validateFileType(String path) {
		System.out.println("If path file has extension csv and file can be read as csv, return true");
		return true;
	}

}
