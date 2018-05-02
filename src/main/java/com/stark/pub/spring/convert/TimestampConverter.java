package com.stark.pub.spring.convert;

import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimestampConverter implements Converter<String, Timestamp> {

	@Override
	public Timestamp convert(String source) {
		if (source == null || "".equals(source.trim())) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			return new Timestamp(formatter.parse(source).getTime());
		} catch (ParseException e) {
			return null;
		}
	}

}