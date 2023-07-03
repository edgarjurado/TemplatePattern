package com.perficient.samples.patterns.template.schema.utils;

import java.util.Map;

public interface ITransformUtils {

	Double scaleValues(Map<String, String> map);

	Double validateValues(Map<String, String> map);

}
