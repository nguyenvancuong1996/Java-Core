package fa.training.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
import fa.training.exception.BirthDayException;
import fa.training.utils.Validator;

public class CandidateService {
	Scanner scanner = new Scanner(System.in);
	Validator validator = new Validator();

	public List<Candidate> inputCandidate() {
		CertificateDAO CertificateDAO = new CertificateDAOImpl();
		CandidateDAO candidateDAO = new CandidateDAOImpl();
		List<Candidate> candidates = new ArrayList<>();
		Candidate candidate = null;
		String phone = null;
		String email = null;
		String candidateID = null;
		String fullName = null;

		String candidate_type = null;
		String canidate_count = null;
		int expInYear = 0;
		String proSkill = null;
		String graduation_date = null;
		String graduation_rank = null;
		String education = null;
		String majors = null;
		String semester = null;
		String university_name = null;
		Date birthDay = null;
		Date graduationDate = null;
		String strDate = null;
		boolean checkDate = true;
		try {
			System.out.println("-------------");
			do {
				System.out.println("Nhap Candidate ID start:");
				candidateID = scanner.nextLine();
			} while (!Validator.checkCandiateID(candidateID));

			System.out.println("Nhap ten :");
			fullName = scanner.nextLine();

			do {
				System.out.println("Nhap BirthDay :");
				strDate = scanner.nextLine();
				try {

					checkDate = validator.checkBirthday(strDate);
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					simpleDateFormat.setLenient(false);
					birthDay = simpleDateFormat.parse(strDate);

				} catch (ParseException e) {
					System.out.println("Vui long nhap lai :");
				} catch (BirthDayException e) {
					System.out.println(e.getMessage());
				}
			} while (!checkDate);

			do {
				System.out.println("Nhap Phone :");
				phone = scanner.nextLine();
			} while (!Validator.checkNumberPhone(phone));
			do {
				System.out.println("Nhap email :");
				email = scanner.nextLine();
			} while (!Validator.checkEmail(email));

			System.out.println("Nhap Candidate_type : 0 experience , 1 fresher , 2 intern");
			candidate_type = scanner.nextLine();

			if (candidate_type.equals("0")) {
				candidate = new Experience();
				System.out.println("Nhap ExpInYear :");
				expInYear = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Nhap ProSkill :");
				proSkill = scanner.nextLine();
				Experience experience = (Experience) candidate;
				experience = new Experience(candidateID, fullName, birthDay, phone, email, candidate_type, expInYear,
						proSkill);
				candidates.add(experience);
				//CertificateDAO.addCertificate(candidateID);
			}
			if (candidate_type.equals("1")) {
				try {

					do {
						System.out.println("Nhap Graduation date : dd/MM/yyyy:");
						graduation_date = scanner.next();
						SimpleDateFormat stf1 = new SimpleDateFormat("dd/MM/yyyy");
						checkDate = validator.checkBirthday(graduation_date);
						stf1.setLenient(false);
						graduationDate = stf1.parse(graduation_date);

					} while (!checkDate);

				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("Nhap Graduation_rank :");
				graduation_rank = scanner.nextLine();
				scanner.nextLine();
				System.out.println("Nhap Education :");
				education = scanner.nextLine();
//				fresher.setBirthDay(birthDay);
//				fresher.setGraduation_date(graduation_date);
				Fresher fresher = (Fresher) candidate;
				fresher = new Fresher(candidateID, fullName, birthDay, phone, email, candidate_type, graduationDate,
						graduation_rank, education);
				candidates.add(fresher);
				
				
			}
			if (candidate_type.equals("2")) {
				System.out.println("Nhap Majors :");
				majors = scanner.nextLine();
				System.out.println("Nhap Semester :");
				semester = scanner.nextLine();
				System.out.println("Nhap University_name :");
				university_name = scanner.nextLine();
				Intern intern = (Intern) candidate;
				intern = new Intern(candidateID, fullName, birthDay, phone, email, candidate_type, canidate_count,
						majors, semester, university_name);
				candidates.add(intern);
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return candidates;
	}

	public void ShowCandidateName(CandidateService candidateService) {
		CandidateDAO dao = new CandidateDAOImpl();
		List<Candidate> listshow = dao.getAllCandidate();
		String sb ="";
		for (Candidate candidate : listshow) {
			sb+=candidate.getFullName()+",";

		}
		String sbs =sb.substring(0,sb.length()-1);
		System.out.println(sbs);
//		if (sb.toString().indexOf(",") != -1) {
//			String abc = null;
//			abc = sb.toString().substring(0,sb.toString().length() - 1);
//			System.out.println(abc);
//
//		}
	}

	public List<Candidate> deleteGmail(List<Candidate> list){
		List<Candidate> list1 = new ArrayList<Candidate>();
		for(Candidate x:list) {
			if(!list1.contains(x)) {
               list1.add(x);
			}
		}
		return list1;
	} 

}
