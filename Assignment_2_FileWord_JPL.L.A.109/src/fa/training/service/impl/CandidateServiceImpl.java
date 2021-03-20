package fa.training.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import fa.training.dao.impl.CandidateDAOImpl;
import fa.training.dao.impl.CertificateDAOImpl;
import fa.training.entity.Candidate;
import fa.training.entity.Certificate;
import fa.training.entity.Experience;
import fa.training.entity.Fresher;
import fa.training.entity.Intern;
import fa.training.exception.BirthDayException;
import fa.training.exception.EmailException;
import fa.training.exception.PhoneException;
import fa.training.service.CandidateService;
import fa.training.utils.Constants;
import fa.training.utils.Validator;

public class CandidateServiceImpl implements CandidateService {

	@Override
	public Candidate addCandidate() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap candidate name");
		String name = scanner.nextLine();
		boolean validate = false;

		String dateStr = null;
		Date date = null;
		boolean birthdayFlag = true;
		do {
			System.out.println("Nhap candidate birthdate: ");
			dateStr = scanner.nextLine();
			try {

				birthdayFlag = !Validator.checkDate(dateStr);
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				simpleDateFormat.setLenient(false);
				date = simpleDateFormat.parse(dateStr);
			} catch (BirthDayException e) {
				System.out.println(e.getMessage());
			} catch (ParseException | DateTimeParseException e2) {
				System.out.println("Loi dinh dang dd/MM/yyyy");
			}

		} while (birthdayFlag);

		String phone = null;
		boolean flag = true;
		do {
			try {
				System.out.println("Nhap Candidate Phone: ");
				phone = scanner.nextLine();
			flag = !Validator.checkPhoneNumber(phone);
			} catch (PhoneException e) {
				System.out.println(e.getMessage());
			}
		} while (flag);


		String email = null;
		boolean emailFlag = true;
		do {
			try {
				System.out.println("Nhap candidate Email:");
				email = scanner.nextLine();
				emailFlag = !Validator.checkEmail(email);
			} catch (EmailException e) {
				System.out.println(e.getMessage());
			}
		} while (emailFlag);

		System.out.println("Nhap candidate type: ");
		System.out.println("0: Experience ");
		System.out.println("1: Fresher ");
		System.out.println("2: Intern ");
		int candidateType = scanner.nextInt();
		scanner.nextLine();


		switch (candidateType) {
		case 0:
			Experience e = new Experience();
			e.setFullName(name);
			e.setBirthDay(date);
			e.setPhone(phone);
			e.setEmail(email);
			e.setCandidateType(candidateType);
			System.out.println("Nhap Exp in Year: ");
			int expInYear = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Nhap Proskill");
			String proSkill = scanner.nextLine();
			e.setExpInYear(expInYear);
			e.setProSkill(proSkill);
			return e;
		case 1:
			Fresher fresher = new Fresher();
			fresher.setFullName(name);
			fresher.setBirthDay(date);
			fresher.setPhone(phone);
			fresher.setEmail(email);
			fresher.setCandidateType(candidateType);
			String dateGraduation;
			Date dateGraduate = null;
			validate = false;
			do {
				System.out.println("Nhap Graduation Date: ");
				dateGraduation = scanner.nextLine();
				try {
					validate = Validator.checkDate(dateGraduation);
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATEFORMAT);
					// bat buoc phai setLenient neu khong se bi tu dong tang len
					simpleDateFormat.setLenient(false);
					dateGraduate = simpleDateFormat.parse(dateGraduation);
				} catch (BirthDayException | ParseException bd) {
					
					System.out.println(bd.getMessage());
				}
			} while (!validate);
			fresher.setGraduationDate(dateGraduate);
			System.out.println("Nhap Graduation Rank: ");
			String graduationRank = scanner.nextLine();
			fresher.setGraduationRank(graduationRank);

			System.out.println("Nhap Education: ");
			String education = scanner.nextLine();
			fresher.setEducation(education);
			return fresher;
		case 2:
			Intern intern = new Intern();
			intern.setFullName(name);
			intern.setBirthDay(date);
			intern.setPhone(phone);
			intern.setEmail(email);
			intern.setCandidateType(candidateType);

			System.out.println("Nhap Majors: ");
			String majors = scanner.nextLine();
			intern.setMajors(majors);
			System.out.println("Nhap Semester: ");
			String semester = scanner.nextLine();
			intern.setSemester(semester);
			System.out.println("Enter University Name: ");
			String universityName = scanner.nextLine();
			intern.setUniversityName(universityName);
			return intern;
		default:
			break;

		}
		return null;
	}

	@Override
	public List<Candidate> getAllCandidate() {
		CandidateDAOImpl candidateDAOImpl = new CandidateDAOImpl();
		List<Candidate> listCandidates = candidateDAOImpl.getAllCandidate();
		return listCandidates;
	}

	@Override
	public void printCandidateFullName() {
		CandidateDAOImpl candidateDAOImpl = new CandidateDAOImpl();
		List<Candidate> listCandidates = candidateDAOImpl.getAllCandidate();
		//StringBuffer được sử dụng để tạo chuỗi có thể thay đổi
		StringBuffer stringBuffer = new StringBuffer();
		for (Candidate candidate : listCandidates) {
			stringBuffer.append(candidate.getFullName());
			stringBuffer.append(",");
		}
		stringBuffer.deleteCharAt(stringBuffer.length() - 1);
		System.out.println(stringBuffer.toString());
	}

	@Override
	public void showInfo() {
		// Yeu cau 1 cau 6 - downcasting upcasting
		CandidateDAOImpl candidateDAOImpl = new CandidateDAOImpl();
		List<Candidate> listCandidates = candidateDAOImpl.getAllCandidate();
		for (Candidate candidate : listCandidates) {
			System.out.println("-------------------------");


			candidate.showMe();
		}

	}

	// phan 3 cau 1
	@Override
	public Set<Candidate> duplicateEmailCandidate() {
		Set<Candidate> setCandidate = new HashSet<Candidate>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		};

		List<Candidate> listCandidate = getAllCandidate();
		for (Candidate candidate : listCandidate) {
			setCandidate.add(candidate);
		}
		for (Candidate candidate : setCandidate) {
			candidate.showMe();
			System.out.println("--------------------------");
		}
		return null;
	}

	@Override
	public List<Candidate> sortCandidate() {
		System.out.println("SORT");
		List<Candidate> listCandidates = getAllCandidate();
		Collections.sort(listCandidates);
		for (Candidate candidate : listCandidates) {
			System.out.println("----------------");
			candidate.showMe();
		}
		return listCandidates;
	}

	@Override
	public void addCandidateCertificate() {
		CandidateDAOImpl candidateDAOImpl = new CandidateDAOImpl();
		CertificateServiceImpl certificateServiceImpl = new CertificateServiceImpl();
		CertificateDAOImpl certificateDAOImpl = new CertificateDAOImpl();
		int candidateID = candidateDAOImpl.insert(addCandidate());
		Certificate certificate = null;
		Scanner scanner = new Scanner(System.in);
		boolean status = false;
		do {
			System.out.println("Nhan Enter de nhap Certificate , N de dung lai ");
			String inputContinue = scanner.nextLine();
			if(inputContinue.toLowerCase().equals("n")) {
				status= true;
			}else {
				certificate = certificateServiceImpl.addCertificate();
				certificateDAOImpl.insertCertificate(certificate, candidateID);
			}
		}while(!status);
	}
	

}
