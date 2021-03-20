package fa.training.service;

import java.util.Scanner;

public class ExperienceService {
	Scanner scanner = new Scanner(System.in);

	int ExpInYear;
	String ProSkill;

	public void inputExperience() {
		System.out.println("Nhap ExpInYear :");
		ExpInYear = scanner.nextInt();
		System.out.println("Nhap ProSkill :");
		ProSkill = scanner.nextLine();

	}
}
