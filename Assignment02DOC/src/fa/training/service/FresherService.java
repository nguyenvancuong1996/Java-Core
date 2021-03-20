package fa.training.service;

import java.util.Scanner;

import fa.training.utils.Validator;

public class FresherService {
	String Graduation_date;
	String Graduation_rank;
	String Education;
	Scanner scanner = new Scanner(System.in);

	public void inputFresher() {
		try {
			new Validator();
			do {
				System.out.println("Nhap Graduation_date :");
				Graduation_date = scanner.nextLine();
			} while (!Validator.checkBirthday(Graduation_date));

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Nhap Graduation_rank :");
		Graduation_rank = scanner.nextLine();
		System.out.println("Nhap Education :");
		Education = scanner.nextLine();
	}
}