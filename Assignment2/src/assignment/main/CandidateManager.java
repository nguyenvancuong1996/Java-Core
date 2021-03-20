package assignment.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assignment.dao.CandidateDao;
import assignment.dao.CandidateDaoImpl;
import assignment.dao.CertificateDao;
import assignment.dao.CertificateDaoImpl;
import assignment.entities.Candidate;
import assignment.entities.Certificate;
import assignment.exception.ExceptionLuachon;
import assignment.service.CandidateService;
import assignment.service.CertificateService;

public class CandidateManager {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		CandidateService candidateService = new CandidateService();
		CandidateDao candidateDao = new CandidateDaoImpl();
		CertificateDao certificateDao = new CertificateDaoImpl();
		CertificateService certificateService = new CertificateService();
		Certificate certificate = null;
		boolean checkloopCandidate = true, checkloopCertificate = true, check = true;
		Candidate candidate = null;
		List<Candidate> candidateslist = new ArrayList<>();
		int luachon = 0;
		do {
			menu();
			System.out.println("Nhap lua cho cua ban");
			try {
				luachon = Integer.parseInt(sc.nextLine());
				if (luachon < 0 && luachon > 9) {
					throw new ExceptionLuachon("Vui long nhap trong 1->9!");
				}
			} catch (ExceptionLuachon e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Vui long nhap so");
			} catch (NullPointerException e) {
				System.out.println("Vui long nhap!");
			}
			switch (luachon) {
			case 1: {
				do {
					candidate = candidateService.createrCandidate();
					if (candidateDao.addCandidate(candidate)) {
						System.out.println("them candidate thanh cong");
					} else {
						System.out.println("them candidate that bai");
					}
					do {
						certificate = certificateService.createrCertificate(candidate);
						if (certificateDao.addCertificate(certificate)) {
							System.out.println("them certificate thanh cong !");
						} else {
							System.out.println("them certificate that bai !");
						}
						System.out.println("Ban muon tiep tuc certificate  khong y/n");
						String lccertificate = sc.nextLine();
						if (lccertificate.equalsIgnoreCase("n")) {
							checkloopCertificate = false;
						}
					} while (checkloopCertificate);

					System.out.println("Ban muon tiep tuc them ung vien khong y/n");
					String lc = sc.nextLine();

					if (lc.equalsIgnoreCase("n")) {
						checkloopCandidate = false;
					}

				} while (checkloopCandidate);
				break;
			}
			case 2: {
				candidateslist = candidateService.getAllCandidate();
				for (Candidate candidate2 : candidateslist) {
					candidate2.showInfor();
					System.out.println("--------------------");
				}
				break;
			}
			case 3: {
				System.out.println("With String .");
				candidateService.nameString(candidateslist);
				System.out.println("---------------");
				System.out.println("With StringBuffer .");
				candidateService.nameStringBuffer(candidateslist);
				break;
			}
			case 4: {
				System.out.println("Xoa email trung ");
				List<Candidate> canlist=candidateService.removeEmaiTrung(candidateslist);
				for (Candidate candidate2 : canlist) {
					candidate2.showInfor();
					System.out.println("-----------------");
				}
				break;
			}
			case 5: {
				System.out.println("Sap xep");
				candidateService.sortCandidateType(candidateslist);
				break;
			}
			case 6: {
				candidateDao.updateResultSet();
				candidateslist = candidateService.getAllCandidate();
				for (Candidate candidate2 : candidateslist) {
					candidate2.showInfor();
					System.out.println("------------------");
				}
				break;
			}
			case 7: {
				candidateDao.insertResultSet();
				candidateslist = candidateService.getAllCandidate();
				for (Candidate candidate2 : candidateslist) {
					candidate2.showInfor();
					System.out.println("------------------");
				}
				break;
			}
			case 8: {

				break;
			}
			case 9: {
				System.out.println("----------GOODBYE--------");
				check = false;
				break;
			}

			default:
				break;
			}

		} while (check);
	}

	public static void menu() {
		System.out.println("1. Insert du lieu ");
		System.out.println("2. xuat du lieu ");
		System.out.println("3. String and StringBufer");
		System.out.println("4. Remove email trung ");
		System.out.println("5. Sort  ");
		System.out.println("6. Update with ResultSet ");
		System.out.println("7. Insert with ResultSet ");
		System.out.println("8. xuat cretificate ");
		System.out.println("9. Exit ");
	}

}
