package fa.training;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator {
	private static final String VALID_EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
	public static final String VALID_PHONE_REGEX = "(03|07|08|09|01[2|6|8|9])+([0-9]){8}";
	public static boolean isEmail(String emailAddress) {
		Pattern pattern = Pattern.compile(VALID_EMAIL_REGEX);
		Matcher matcher = pattern.matcher(emailAddress);
		return matcher.matches();
		
	}
	public static boolean isValidPhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile(VALID_PHONE_REGEX);
		Matcher matcher = pattern.matcher(phoneNumber);
		if (matcher.matches()) {
			return true;
		} else {
//			System.out.println("!!!Invalid phone number");
			return false;
		}
	}
}
