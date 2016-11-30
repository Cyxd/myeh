package com.cyxd.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	private final static String DATA_PATTERN_19 = "yyyy-MM-dd HH:mm:ss";

	private static SimpleDateFormat sdf_19 = new SimpleDateFormat(DATA_PATTERN_19);

	private DateUtils() {
		super();
	}

	public static String currDateTime() {
		return sdf_19.format(new Date());
	}

}
