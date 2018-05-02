package com.stark.pub.spring.convert;

import org.springframework.core.convert.converter.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		if (source == null || "".equals(source.trim())) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			return formatter.parse(source);
		} catch (ParseException e) {
			return null;
		}
	}
}
