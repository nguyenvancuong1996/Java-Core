package assignment.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ConvertDateToLocalDate {
	
	public static LocalDate oldDateToLocalDate(Date b) {
		LocalDate localDate = null;
		Instant instant = Instant.ofEpochMilli(b.getTime());
		localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
		return localDate;
	}

}
