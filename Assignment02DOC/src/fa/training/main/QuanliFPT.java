package fa.training.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import fa.training.dao.CandidateDAO;
import fa.training.dao.CertificateDAO;
import fa.training.dao.impl.CandidateDAOImpl;
import fa.training.dao.impl.CertificateDAOImpl;
import fa.training.entitis.Candidate;
import fa.training.entitis.Experience;
import fa.training.entitis.Fresher;
import fa.training.entitis.Intern;
import fa.training.service.CandidateService;

public class QuanliFPT {

	public static void main(String[] args) {
		CertificateDAO certificateDAO = new CertificateDAOImpl();
		Scanner nhap = new Scanner(System.in);
		CandidateDAO candidateDAO = new CandidateDAOImpl();
		CandidateService one = new CandidateService();
		List<Candidate> canList ;
		boolean check = true;
		while (check) {
			System.out.println("------------------");
			System.out.println("---MENU CANDIDATE----");
			System.out.println("1 .them candidate :");
			System.out.println("2 .thien thi tat ca");
			System.out.println("3 .hien thi tat ca ten ( , ) :");
			System.out.println("4 .sap xep email trung nhau :");
			System.out.println("5 .sap xep");
			System.out.println("6. update rs :");
			System.out.println("7. insert rs :");
			System.out.println("8. --Stop program--");
			int key = nhap.nextInt();
			switch (key) {
			case 1:
		//		System.out.println("add Candidate :");
			//	System.out.println("-------------------");
				List<Candidate> list = one.inputCandidate();
				for (Candidate x : list) {
					candidateDAO.Candidateinsert(x);
					System.out.println(x.getCandidateID());
					certificateDAO.addCertificate(x.getCandidateID());
				}
				break;
			case 2:
				canList = candidateDAO.getAllCandidate();
			//	System.out.println("show All infor Candidate :");
	

				for (Candidate candidate : canList) {
					System.out.println(candidate.ShowMe());
				}
				break;
			case 3:
		//		System.out.println("Show name +[ , ] Candidate ");

				one.ShowCandidateName(one);
				break;

			case 4:
		//		System.out.println("delete");
			//	System.out.println("-------------------");

				List<Candidate> list1 = one.deleteGmail(candidateDAO.getAllCandidate());
				for (Candidate x : list1) {
					if (x instanceof Experience) {
						Experience experience = (Experience) x;
						System.out.println(experience.ShowMe());
					}
					if (x instanceof Fresher) {
						Fresher Fresher = (Fresher) x;
						System.out.println(Fresher.ShowMe());
					}
					if (x instanceof Intern) {
						Intern Intern = (Intern) x;
						System.out.println(Intern.ShowMe());
					}
				}
				break;
			case 5:

				List<Candidate> list3 = one.deleteGmail(candidateDAO.getAllCandidate());
				Collections.sort(list3);
				for (Candidate x : list3) {
					System.out.println(x.ShowMe());
				}
				break;
			case 6:
			

				System.out.println("Nhap hang can update");
				int row = nhap.nextInt();
				nhap.nextLine();
				System.out.println("Nhap ten moi:");
				String name = nhap.nextLine();
				candidateDAO.update(name, row);
				break;
			case 7:
				System.out.println("-------------------");

				candidateDAO.insertViaResultSet();
				break;
			case 8:
				check = false;
			default:
			}
		}
	}
	/*
	 * System.out.println("1. Add Candidate");
	 * System.out.println("2. Print all Candidate's name with , between");
	 * System.out.println("3. Print all Candidate without Duplicate Email");
	 * System.out.println("4. Show Info of All Candidate"); System.out.
	 * println("5. Print all Candidate Sorted by CandidateType, Year of Birth");
	 * System.out.println("6. Update Candidate Via ResultSet");
	 * System.out.println("7. Insert Candidate Via ResultSet");
	 * System.out.println("8. Exit Program");
	 * System.out.println("Enter your choice: ");
	 */
}