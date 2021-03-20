package assignment.utils;

import java.time.LocalDate;
import java.util.List;

import assignment.entities.Candidate;

public class Validator {
	public static final String VALID_PHONE_REGEX = "(03|07|08|09|01[2|6|8|9])+([0-9]){8}";

	public static boolean validatetorBirthDayYear(LocalDate birthDay) {
		if (birthDay.getYear() >= 1990 && birthDay.getYear() <= 2020) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkCandiateID(String ID) {
		if (ID.length() == 5) {
			return true;
		}
		return false;
	}

	public static boolean checkEmail(String email) {
		if (email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(.com)*$")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkCertificateID(String ID) {
		if (ID.length() == 5) {
			return true;
		}
		return false;
	}

	public static boolean checkIDtrung(String candidateID, List<Candidate> listCandidate) {

		for (int i = 0; i < listCandidate.size(); i++) {
			if (candidateID.equals(listCandidate.get(i).getCadidateID())) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkPhone(String phone) {
		if (phone.matches(VALID_PHONE_REGEX) && phone.length() == 10) {
			return true;
		}
		return false;
	}

}
