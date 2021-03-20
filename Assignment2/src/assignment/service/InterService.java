package assignment.service;

import java.util.Scanner;

import assignment.entities.Candidate;
import assignment.entities.Inter;

public class InterService {

	public Inter createrInter(Candidate candidate) {
		Scanner sc = new Scanner(System.in);
		Inter inter = (Inter) candidate;
		int semester = 0;
		String universityName = null, majors = null;
		boolean checksemester = true, checkuniversityName = true, checkMajors = true;

		do {
			System.out.println("Nhap Majors :");
			try {
				majors = sc.nextLine();
				checkMajors = false;
			} catch (NullPointerException e) {
				System.out.println("Vui long nhap");
			}
		} while (checkMajors);

		do {
			System.out.println("Nhap semester :");
			try {
				semester = Integer.parseInt(sc.nextLine());
				checksemester = false;
			} catch (NullPointerException e) {
				System.out.println("Vui long nhap");
			} catch (NumberFormatException e) {
				System.out.println("Vui long nhap so :");
			}
		} while (checksemester);

		do {
			System.out.println("Nhap UniversityName :");
			try {
				universityName = sc.nextLine();
				checkuniversityName = false;
			} catch (NullPointerException e) {
				System.out.println("Vui long nhap");
			}
		} while (checkuniversityName);

		inter = new Inter(candidate.getCadidateID(), candidate.getFullName(), candidate.getBirthDay(),
				candidate.getPhone(), candidate.getEmail(), candidate.getCandidate_type(), majors, semester,
				universityName);

		return inter;

	}

}
