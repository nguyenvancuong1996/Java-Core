package fa.training.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	public static boolean isValidPhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile(Constants.VALID_PHONE_REGEX);
		Matcher matcher = pattern.matcher(phoneNumber);
		if (matcher.matches()) {
			return true;
		} else {
			System.out.println("!!!Invalid phone number");
			return false;
		}
	}

	public static boolean isValidOrderNumber(String orderNumber) {
		if (orderNumber.length() == 10) {
			return true;
		} else {
			System.out.println("!!!Invalid order number , must have 10 number");
			return false;
		}
	}

	public static boolean isValidDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		try {
			@SuppressWarnings("unused")
			LocalDate date1 = LocalDate.parse(date, formatter);
			return true;
		} catch (Exception e) {
			System.out.println("!!!invalid date please try again dd/MM/yyyy");
			return false;
		}
	}
}
