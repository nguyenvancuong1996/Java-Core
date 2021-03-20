package fa.training.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DatetoLocalday {

	public static LocalDate oldDateToLocalDate(Date b) {
		LocalDate localDate = null;
		Instant instant = Instant.ofEpochMilli(b.getTime());
		localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
		return localDate;
	}

	public static Date localDateToOldDate(LocalDate birthDay) {
		Date oldDate = Date.from(birthDay.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

		return oldDate;
	}

}
