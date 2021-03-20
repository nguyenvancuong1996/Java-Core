package fa.training.service;

import java.util.Scanner;

public class InternService {
	String Majors;
	String Semester;
	String University_name;
	Scanner scanner = new Scanner(System.in);

	public void inputIntern() {
		System.out.println("Nhap Majors :");
		Majors = scanner.nextLine();
		System.out.println("Nhap Semester :");
		Semester = scanner.nextLine();
		System.out.println("Nhap University_name :");
		University_name = scanner.nextLine();
	}
}
