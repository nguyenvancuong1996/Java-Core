package fa.training.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

import fa.training.entity.CandidateCertificate;
import fa.training.exception.BirthDayException;
import fa.training.service.CertificateService;
import fa.training.utils.Validator;

public class CertificateServiceImpl implements CertificateService {

	@Override
	public CandidateCertificate addCertificate() {
		Scanner scanner = new Scanner(System.in);
		CandidateCertificate candidateCertificate = new CandidateCertificate();
		System.out.println("Enter Certificate Name: ");
		String cerName = scanner.nextLine();
		System.out.println("Enter Certificate Rank");
		String cerRank = scanner.nextLine();
		String dateStr = null;
		Date cerDate = null;
		boolean cerDateFlag = true;
		do {
			System.out.println("Enter Certificate Date: ");
			dateStr = scanner.nextLine();
			try {
				cerDateFlag = !Validator.isValidDate(dateStr);
				cerDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
			} catch (BirthDayException e) {
				System.out.println(e.getMessage());
			} catch (ParseException | DateTimeParseException e2) {
				System.out.println("Date time format must be dd/MM/yyyy");
			}
		} while (cerDateFlag);
		candidateCertificate.setCertificateName(cerName);
		candidateCertificate.setCertificateDate(cerDate);
		candidateCertificate.setCertificateRank(cerRank);
		return candidateCertificate;
	}

}
