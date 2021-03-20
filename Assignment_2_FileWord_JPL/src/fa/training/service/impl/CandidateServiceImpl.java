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
import fa.training.entity.CandidateCertificate;
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
		System.out.println("Enter candidate name");
		String name = scanner.nextLine();
		boolean validate = false;

		String dateStr = null;
		Date date = null;
		boolean birthdayFlag = true;
		do {
			System.out.println("Enter candidate birthdate: ");
			dateStr = scanner.nextLine();
			try {
				// validate = Validator.isValidDate(dateStr);
//				date = Date.from(LocalDate.parse(dateStr).atZone(ZoneId.systemDefault()).toInstant());
				birthdayFlag = !Validator.isValidDate(dateStr);
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				simpleDateFormat.setLenient(false);
				date = simpleDateFormat.parse(dateStr);
			} catch (BirthDayException e) {
				System.out.println(e.getMessage());
			} catch (ParseException | DateTimeParseException e2) {
				System.out.println("Date time format must be dd/MM/yyyy");
			}

		} while (birthdayFlag);

		String phone = null;
		boolean phoneFlag = true;
		do {
			try {
				System.out.println("Enter Candidate Phone: ");
				phone = scanner.nextLine();
				phoneFlag = !Validator.isValidPhoneNumber(phone);
			} catch (PhoneException e) {
				System.out.println(e.getMessage());
			}
		} while (phoneFlag);
//		
//		do {
//			System.out.println("Enter candidate phone: ");
//			phone = scanner.nextLine();
//			validate = true;
//			// validate = Validator.isValidPhoneNumber(phone);
//		} while (!validate);

//		validate = false;
//		String email=null;
//		do {
//			System.out.println("Enter candidate email: ");
//			
//			email = scanner.nextLine();
//			try {
//				validate = Validator.isEmail(email);
//			} catch (EmailException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			if(!validate) {
//				throw new EmailException("Input mismatch phone number format, please try again!");
//				continue;
//			}
//		}while(!validate);

		String email = null;
		boolean emailFlag = true;
		do {
			try {
				System.out.println("Enter candidate Email:");
				email = scanner.nextLine();
				emailFlag = !Validator.isEmail(email);
			} catch (EmailException e) {
				System.out.println(e.getMessage());
			}
		} while (emailFlag);

		System.out.println("Enter candidate type: ");
		System.out.println("0: Experience ");
		System.out.println("1: Fresher ");
		System.out.println("2: Intern ");
		int candidateType = scanner.nextInt();
		scanner.nextLine();

//		candidate.setFullName(name);
//		candidate.setBirthDay(date);
//		candidate.setPhone(phone);
//		candidate.setEmail(email);
//		candidate.setCandidateType(candidateType);
		switch (candidateType) {
		case 0:
			Experience e = new Experience();
			e.setFullName(name);
			e.setBirthDay(date);
			e.setPhone(phone);
			e.setEmail(email);
			e.setCandidateType(candidateType);
			System.out.println("Enter Exp in Year: ");
			int expInYear = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter Proskill");
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
				System.out.println("Enter Graduation Date: ");
				dateGraduation = scanner.nextLine();
				try {
					validate = Validator.isValidDate(dateGraduation);
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATETIMEFORMAT);
					simpleDateFormat.setLenient(false);
					dateGraduate = simpleDateFormat.parse(dateGraduation);
				} catch (BirthDayException | ParseException bde) {
					//ParseException never trigger because it's been detected before in Validator.isValidDate
					System.out.println(bde.getMessage());
				}
			} while (!validate);
			fresher.setGraduationDate(dateGraduate);
			System.out.println("Enter Graduation Rank: ");
			String graduationRank = scanner.nextLine();
			fresher.setGraduationRank(graduationRank);

			System.out.println("Enter Education: ");
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

			System.out.println("Enter Majors: ");
			String majors = scanner.nextLine();
			intern.setMajors(majors);
			System.out.println("Enter Semester: ");
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
	public void printAllCandidateFullName() {
		CandidateDAOImpl candidateDAOImpl = new CandidateDAOImpl();
		List<Candidate> listCandidates = candidateDAOImpl.getAllCandidate();
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
//			if (candidate instanceof Experience) {
//
//				System.out.println("Candidate : Experience");
//			}
//			if (candidate instanceof Fresher) {
//				System.out.println("Candidate : Fresher");
//			}
//			if (candidate instanceof Intern) {
//				System.out.println("Candidate : Intern");
//			}
			candidate.showMe();
		}

	}

	// Yeu cau 3 cau 1
	@Override
	public Set<Candidate> readNonduplicateEmailCandidate() {
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
	public List<Candidate> getSortCandidate() {
		System.out.println(">>>>>>>>>>>>>>>>>>SORTED CANDIDATE<<<<<<<<<<<<<");
		List<Candidate> listCandidates = getAllCandidate();
		Collections.sort(listCandidates);
		for (Candidate candidate : listCandidates) {
			System.out.println("----------------");
			candidate.showMe();
		}
		return listCandidates;
	}

	@Override
	public void addCandidateWithCertificate() {
		CandidateDAOImpl candidateDAOImpl = new CandidateDAOImpl();
		CertificateServiceImpl certificateServiceImpl = new CertificateServiceImpl();
		CertificateDAOImpl certificateDAOImpl = new CertificateDAOImpl();
		int candidateID = candidateDAOImpl.insert(addCandidate());
		CandidateCertificate candidateCertificate = null;
		Scanner scanner = new Scanner(System.in);
		boolean statusEnd = false;
		do {
			System.out.println("Do you want to add certificate? Press Enter to continue or press 'n' to end");
			String inputContinue = scanner.nextLine();
			if(inputContinue.toLowerCase().equals("n")) {
				statusEnd= true;
			}else {
				candidateCertificate = certificateServiceImpl.addCertificate();
				certificateDAOImpl.insertCertificate(candidateCertificate, candidateID);
			}
		}while(!statusEnd);
	}
	

}
