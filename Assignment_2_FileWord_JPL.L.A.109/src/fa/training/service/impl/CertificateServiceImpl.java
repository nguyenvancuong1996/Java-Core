package fa.training.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

import fa.training.entity.Certificate;
import fa.training.exception.BirthDayException;
import fa.training.service.CertificateService;
import fa.training.utils.Validator;

public class CertificateServiceImpl implements CertificateService {

	@Override
	public Certificate addCertificate() {
		Scanner scanner = new Scanner(System.in);
		Certificate candidateCert = new Certificate();
		System.out.println("Nhap Certificate Name: ");
		String cerName = scanner.nextLine();
		System.out.println("Nhap Certificate Rank");
		String cerRank = scanner.nextLine();
		String dateStr = null;
		Date cerDate = null;
		boolean cDateFlag = true;
		do {
			System.out.println("Nhap Certificate Date: ");
			dateStr = scanner.nextLine();
			try {
				cDateFlag = !Validator.checkDate(dateStr);
				cerDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
			} catch (BirthDayException e) {
				System.out.println(e.getMessage());
			} catch (ParseException | DateTimeParseException e2) {
				System.out.println("Sai dinh dang dd/MM/yyyy");
			}
		} while (cDateFlag);
		candidateCert.setCertificateName(cerName);
		candidateCert.setCertificateDate(cerDate);
		candidateCert.setCertificateRank(cerRank);
		return candidateCert;
	}

}
