package assignment.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import assignment.entities.Candidate;
import assignment.entities.Certificate;
import assignment.exception.BirthDayException;
import assignment.exception.ExceptionID;
import assignment.utils.ConvertDateToLocalDate;
import assignment.utils.Validator;

public class CertificateService {

	public Certificate createrCertificate(Candidate candite) {
		Scanner sc = new Scanner(System.in);
		Certificate certificate = new Certificate();
		String certificateID = null, candidateID = null, certificateName = null, certificateRank = null, strDate = null;
		Date certificateDate = null;
		boolean checkID = true, checkName = true, checkRank = true, checkDate = true;

		do {
			System.out.println("Nhap CertificateID  : ");
			try {
				certificateID = sc.nextLine();
				if (!new Validator().checkCertificateID(certificateID)) {
					throw new ExceptionID("Vui long nhap dung format ID !");
				}
				checkID = false;
			} catch (ExceptionID e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException e) {
				System.out.println("Vui long nhap !");
			}

		} while (checkID);

		do {
			System.out.println("Nhap CertificateName  : ");
			try {
				certificateName = sc.nextLine();
				checkName = false;

			} catch (NullPointerException e) {
				System.out.println("Vui long nhap !");
			}

		} while (checkName);

		do {
			System.out.println("Nhap CertificateRank  : ");
			try {
				certificateRank = sc.nextLine();
				checkRank = false;

			} catch (NullPointerException e) {
				System.out.println("Vui long nhap !");
			}

		} while (checkRank);

		do {
			DateFormat stf = new SimpleDateFormat("dd-mm-yyyy");
			System.out.println("Nhap ngay nhan bang :");
			strDate = sc.nextLine();
			try {
				certificateDate = stf.parse(strDate);
				if (!new Validator()
						.validatetorBirthDayYear(ConvertDateToLocalDate.oldDateToLocalDate(certificateDate))) {
					throw new BirthDayException("Vui long nhap nam >1990 <=2020 ");
				}
				checkDate=false;  
			} catch (ParseException e) {
				System.out.println("Vui long nhap dung dinh dang nayf");
			} catch (BirthDayException e) {
				System.out.println(e.getMessage());
			}

		} while (checkDate);

		certificate = new Certificate(certificateID, candite.getCadidateID(), certificateName, certificateRank, certificateDate);
		
		return certificate;
	}

}
