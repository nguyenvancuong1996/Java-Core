package fa.training.main;

import java.util.Scanner;

import fa.training.dao.impl.CandidateDAOImpl;
import fa.training.service.impl.CandidateServiceImpl;
import fa.training.utils.DBUtils;

public class Test {

	public static void main(String[] args) {
		CandidateServiceImpl candidateServiceImpl = new CandidateServiceImpl();
		CandidateDAOImpl candidateDAOImpl = new CandidateDAOImpl();
		
//		Candidate candidate = candidateServiceImpl.addCandidate();
//		candidateDAOImpl.insert(candidate);

		// Yeu cau 2 : Cau 4
//		candidateServiceImpl.printAllCandidateFullName();

		// Yeu cau 2 : Cau 5
//		candidateServiceImpl.showInfo();

		// Yeu cau 3 : Cau 1
//	candidateServiceImpl.readNonduplicateEmailCandidate();
//		
		// Yeu cau 3 : Cau 2
//		candidateServiceImpl.getSortCandidate();

		// Yeu cau 4 : Cau 1
//		candidateDAOImpl.updateViaResultSet();
		// Yeu cau 4 : Cau 2
//		candidateDAOImpl.insertViaResultSet();

//		add candidate then add certificate
//		candidateServiceImpl.addCandidateWithCertificate();
		menu();
	}

	static void menu() {
		CandidateServiceImpl candidateServiceImpl = new CandidateServiceImpl();
		CandidateDAOImpl candidateDAOImpl = new CandidateDAOImpl();
		Scanner scanner = new Scanner(System.in);
		boolean stop = false;
		do {
		System.out.println("--------Menu Program---------------");
		System.out.println("1. Add Candidate");
		System.out.println("2. Print all Candidate's name with , between");
		System.out.println("3. Print all Candidate without Duplicate Email");
		System.out.println("4. Show Info of All Candidate");
		System.out.println("5. Print all Candidate Sorted by CandidateType, Year of Birth");
		System.out.println("6. Update Candidate Via ResultSet");
		System.out.println("7. Insert Candidate Via ResultSet");
		System.out.println("8. Exit Program");
		System.out.println("Enter your choice: ");
		String choice = scanner.nextLine();
		switch (choice) {
		case "1":
			candidateDAOImpl.insert(candidateServiceImpl.addCandidate());
			break;
		case "2":
			candidateServiceImpl.printAllCandidateFullName();
			break;
		case "3":
			candidateServiceImpl.readNonduplicateEmailCandidate();
			break;
		case "4":
			candidateServiceImpl.showInfo();
			break;
		case "5":
			candidateServiceImpl.getSortCandidate();
			break;
		case "6":
			candidateDAOImpl.updateViaResultSet();
			break;
		case "7":
			candidateDAOImpl.insertViaResultSet();
			break;
		case "8":
			stop = true;
			break;
		default:
			break;
		}
		}while(!stop);
	}

}
