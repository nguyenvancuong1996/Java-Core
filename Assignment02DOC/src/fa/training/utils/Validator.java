package fa.training.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fa.training.exception.BirthDayException;
import fa.training.exception.EmailException;
import fa.training.exception.ExceptionPhone;

public class Validator {
	public static boolean checkCandiateID(String ID) {
		if (ID.length() == 5) {
			return true;
		}
		return false;
	}
	public static boolean checkNumberPhone(String phoneNumber) throws ExceptionPhone {
		Pattern pattern = Pattern.compile(Constants.VALID_PHONE_REGEX);
		Matcher matcher = pattern.matcher(phoneNumber);
		if (matcher.matches()) {
			return true;
		} else {
			throw new ExceptionPhone("Sai dinh dang !");

		}
	}

	public static boolean checkBirthday(String date) throws BirthDayException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATEFORMAT, Locale.ENGLISH);

		try {
			LocalDate date1 = LocalDate.parse(date, formatter);
			if (date1.getYear() < 1900 || date1.getYear() > LocalDateTime.now().getYear()
					|| date1.isAfter(LocalDateTime.now().toLocalDate())) {
				// System.out.println("!!!Invalid date must between 1900 and current");
				// return false;
				throw new BirthDayException("!!!Invalid date must between 1900 and current");
			}
		} catch (DateTimeParseException e) {
			throw new BirthDayException("Date time format must be dd/MM/yyyy");
		}
		
		return true;
	}

	public static boolean checkEmail(String emailAddress) throws EmailException {
		Pattern pattern = Pattern.compile(Constants.VALID_EMAIL_REGEX);
		Matcher matcher = pattern.matcher(emailAddress);
		if (matcher.matches()) {
			return true;
		} else {
			throw new EmailException("Sai dinh dang ");
		}
	}
}
