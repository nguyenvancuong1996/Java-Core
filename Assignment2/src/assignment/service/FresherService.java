package assignment.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import assignment.entities.Candidate;
import assignment.entities.Fresher;
import assignment.exception.BirthDayException;
import assignment.utils.ConvertDateToLocalDate;
import assignment.utils.Validator;

public class FresherService {

	public Fresher createrFresher(Candidate candidate) {
		Scanner sc = new Scanner(System.in);
		Fresher fresher = (Fresher) candidate;
		Date gradutionDate = null;
		String education = null, strDate = null, gradutionRank = null;
		boolean checkGradutionRank = true, checkEducation = true, checkDate = true;

		do {
			System.out.println("Nhap GradutionDate :");
			DateFormat stf = new SimpleDateFormat("dd-mm-yyyy");
			try {
				strDate = sc.nextLine();
				gradutionDate = stf.parse(strDate);
				LocalDate localdate = new ConvertDateToLocalDate().oldDateToLocalDate(gradutionDate);
				if (!new Validator().validatetorBirthDayYear(localdate)) {
					throw new BirthDayException("Vui long nhap date lon 1990 va be hon 2020");
				}
				checkDate = false;
			} catch (ParseException e) {
				System.out.println("Vui long nhap lai :");
			} catch (BirthDayException e) {
				System.out.println(e.getMessage());
			}
		} while (checkDate);

		do {
			System.out.println("Nhap GradutionRank :");
			try {
				gradutionRank = sc.nextLine();
				checkGradutionRank = false;
			} catch (NullPointerException e) {
				System.out.println("Vui long nhap");
			}
		} while (checkGradutionRank);

		do {
			System.out.println("Nhap education :");
			try {
				education = sc.nextLine();
				checkEducation = false;
			} catch (NullPointerException e) {
				System.out.println("Vui long nhap");
			}
		} while (checkEducation);

		fresher = new Fresher(candidate.getCadidateID(), candidate.getFullName(), candidate.getBirthDay(),
				candidate.getPhone(), candidate.getEmail(), candidate.getCandidate_type(), gradutionDate, gradutionRank,
				education);

		return fresher;

	}

}
